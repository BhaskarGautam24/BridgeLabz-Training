import java.lang.annotation.*;
// Custom annotation
@Retention(RetentionPolicy.RUNTIME)
@interface Author
{
    String name();
}

@Author(name = "Author Name")
public class Book
{
    // simple class body
}

class AnnotationReader
{
    public static void main(String[] args)
    {
        try
        {
            // Get Class object
            Class classObject = Book.class;

            // Get annotation from class
            Annotation annotationObject = classObject.getAnnotation(Author.class);

            // Type cast Annotation to Author
            Author authorObject = (Author) annotationObject;

            System.out.println("Author Name is: " + authorObject.name());
        }
        catch (Exception e)
        {
            System.out.println("Error occured while reading annotation.");
        }
    }
}

