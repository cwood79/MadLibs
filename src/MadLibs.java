/* Author: Chris Wood */

import java.util.Scanner;
import java.util.StringTokenizer;


// This code implements a basic game of MadLibs. It first reads a text input with <>
// surrounding nouns/adjectives/pronouns etc. The end of the text is marked by a blank line.
// It then asks for words to fill those blanks and then displays the output with those strings.

// Example String format
//<name> went for a walk in the park. <he or she>
//       found a <noun>. <name> decided to take it home.

public class MadLibs
{

    public static void main(String[] args)
    {
        System.out.println("Input story text");
        Scanner sc = new Scanner(System.in);

        StringBuffer text = new StringBuffer();

        // Add lines to buffer
        while(!sc.nextLine().isEmpty())
        {
            text.append(sc.nextLine() + " " );
        }

        StringBuffer resStory = new StringBuffer();


        // Loop through lines in buffer
       // while()
        //{




        //}




        System.out.println(resStory.toString());
    }




}

