class Product implements Cloneable{
    int productId;
    Product(int productId){
        this.productId = productId;
    }
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
public class Clone{
    public static void main(String[] args) throws Exception{
        Product p1 = new Product(500);
        Product p2 = (Product) p1.clone();
        System.out.println("Original ID: " + p1.productId);
        System.out.println("Cloned ID: " + p2.productId);
    }
}

