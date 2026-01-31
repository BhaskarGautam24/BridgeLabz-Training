import java.util.*;
import java.util.stream.*;
class Book{
    private String title;
    private String genre;
    private int pages;
    Book(String title,String genre,int pages){
        this.title=title;
        this.genre=genre;
        this.pages=pages;
    }
    String getGenre(){
        return genre;
    }
    int getPages(){
        return pages;
    }
}
public class BookStatistics{
    public static void main(String[] args){
        List<Book> books=Arrays.asList(
            new Book("Java","Programming",350),
            new Book("Spring","Programming",500),
            new Book("History","History",400)
        );
Map<String,IntSummaryStatistics> stats=books.stream().collect(Collectors.groupingBy(Book::getGenre,Collectors.summarizingInt(Book::getPages)));
        stats.forEach((genre,data)->{
            System.out.println("Genre: "+genre);
            System.out.println("Total Pages: "+data.getSum());
            System.out.println("Average Pages: "+data.getAverage());
            System.out.println("Max Pages: "+data.getMax());
        });
    }
}

