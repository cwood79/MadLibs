/**
 * Chris Wood
 */

/* This program is a simple MadLibs game. The user is prompted to input a multiline text with certain words
 * surrounded by <>. The input is ended with a blank space. The user is then prompted to input a word for each <word>
 * in the text. The text is then output with the new words. Phrases of multiple words in a <> require a - between words.
 */

/* Sample input:
 *  <name> went for a walk in the park. <he-or-she>
 *  found a <noun>. <name> decided to take it home.
 */

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MadLibs {

    public static void main(String[] args)
    {
        System.out.println("Please input text.");

        // Grab input
        Scanner sc = new Scanner(System.in);
        StringBuffer textBuf = new StringBuffer();

        String line;

        // Insert words into buffer
        while(!(line=sc.nextLine()).isEmpty())
        {
            textBuf.append(" " + line);

        }

        // Delete first space
        textBuf.delete(0,1);

        StringBuffer resBuf = new StringBuffer();

        String word;

        StringTokenizer tok = new StringTokenizer(textBuf.toString());

        // Map used to store values
        Map<String, String> map = new HashMap<String, String>();

        // iterate through words
        while(tok.hasMoreTokens())
        {
            word = tok.nextToken();
            String str = "";

            // Regex to find words in <> with punctuation
            if(word.matches("\\<(.*?)\\>[.!?\\\\-]?+"))
            {

                //Add punctuation
                if(word.charAt(word.length()-1) != '>')
                {
                    str = word.substring(word.lastIndexOf('>')+1);
                }

                String id = word.substring(0,word.indexOf('>')+1);
                String value;

                // Check to see if word has already been replaced
                if(!map.containsKey(id))
                {
                    System.out.println("Please type a " + word);
                    value = sc.nextLine() + str;
                    map.put(id, value);
                }

                // use existing replacement
                else
                {
                    value = map.get(id);
                }
                word = value;

            }

            resBuf.append(word + " ");

        }

        // Print the final result
        System.out.println(resBuf.toString());
        sc.close();
    }
}
