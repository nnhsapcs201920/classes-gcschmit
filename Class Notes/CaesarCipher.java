import java.util.Scanner;

/**
 * This class encrypts strings with a keyphrase version of the classic
 *      Caesar Cipher.
 *      (as described in The Code Book by Simon Singh)
 *
 * @author gcschmit
 * @version 21 September 2018
 */
public class CaesarCipher
{
    /*
     * static: one value for the variable for all objects of the class.
     *      This is like class attributes in Python.
     *      Static class variables can be accessed directly through the class
     *          (e.g., CaesarCipher.ALPHABET, Math.PI, Color.RED).
     *          
     *  "ABCDEFGHIJKLMNOPQRSTUVWXYZ" is a String literal equivalent to:
     *      new String("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
     */
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args)
    {
        /*
         * A scanner object parses primitives types and Strings from a stream.
         * 
         * A stream is a sequence of characters from a file, String, terminal, network, etc.
         * 
         * Parsing is separating a sequence of characters into tokens based on delimiters.
         *      A token is a meaningful sequence of characters (e.g., word).
         *      Delimiters are characters that separate tokens
         *          (by default, whitespace (space, tab, newline) is the delimiter).
         *  
         *  When we create a Scanner object, we have to specify the input stream
         *      (e.g., System.in which is the keyboard via ther terminal).
         */
        Scanner s = new Scanner(System.in);

        /*
         * Best practices:
         *      1. prompt the user for what you want them to input
         *      2. use, print, not println, such that the cursor is at the end of the prompt
         *          and not on a new line
         *      3. leave a space after the prompt
         */
        System.out.print("Enter the text to encrypt: ");

        /*
         * The nextLine method returns all the characters up to the end of the line
         *      (i.e., where the user typed enter).
         */
        String text = s.nextLine();
        text = text.toUpperCase();

        System.out.print("Enter the keyphrase (no spaces): ");

        /*
         * The next method returns the next token in the stream as a String.
         */
        String keyphrase = s.next();
        keyphrase = keyphrase.toUpperCase();

        System.out.print("Enter the number of seconds to test a guessed keyphrase: ");

        /*
         * The nextInt method attempts to convert the next token in the stream to an int
         *      and returns the value. If the next token cannot be converted, an exception
         *      is generated.
         *      
         *  The nextDouble method behaves in the same way for doubles.
         */
        int secondsPerGuess = s.nextInt();

        // prepare the keyphrase by removing duplicate letters
        keyphrase = CaesarCipher.compressKeyphrase(keyphrase);
        
        long averageTimeToCrack = CaesarCipher.calculateAverageTimeToCrack(
                keyphrase.length(), secondsPerGuess);
                
        CaesarCipher.printAverageTimeToCrack(averageTimeToCrack);
        
        String encryptedText = CaesarCipher.encrypt(text, keyphrase);
        System.out.println("Encrypted: " + encryptedText);
        
        /*
         * The Math.random static method returns a double  [0.0 ... 1.0).
         * 
         *  Often we use the following algorithm to generate a random integer from min (inclusive)
         *      to max (inclusive):
         *      
         *      int n = (int)((Math.random() * (max - min + 1)) + min);
         *      
         *  For example: generate a random int [1 ... 26]
         */
        int letterIndex = (int)((Math.random() * 26) + 1);
    }
    /**
     * Formats the average time to crack the cipher based on the specified number of seconds and
     *      displays via System.out in several formats.
     *      
     *  This method is static and, therefore, is independent of the state of a CeasarCipher object.
     *      As a result, this method may be invoked on the class instead of a variable that
     *      references an object (e.g., CaesarCipher.printAverageTimeToCrack(10000000L);)
     *      In addition, this method cannot access any instance variables.
     *      
     *  @param totalSeconds     the average number of seconds to crack the cipher
     */
    public static void printAverageTimeToCrack(long totalSeconds)
    {
        /*
         * Instead of using a "magic number" (e.g., 3.14159), use constants defined by us or
         *      the Java Standard Library.
         *      
         *  For example, in the Math class is defined:
         *      public static final double PI = 3.141592654;
         *      
         *  Declare a constant with the final keyword.
         *      By conventions, constants are in all caps with underscores.
         */
        final int SECONDS_FOR_EVERY_MINUTE = 60;
        final int MINUTES_FOR_EVERY_HOUR = 60;
        final int HOURS_FOR_EVERY_DAY = 24;
        final int DAYS_FOR_EVERY_YEAR = 365;

        // if we try to change the value, a compiler error will be generated
        //SECONDS_FOR_EVERY_MINUTE = 30;

        /*
         * Use integer division to calculate how many whole minutes based on the specified
         *      number of  seconds.
         *  
         *  Integer division (like // operator in Python) discards the remainder (truncates).
         *  
         *  Java does integer division when both operands are integer types;
         *      floating-point division occurs when one or both operands are floating-point types.
         *      
         *  For example:
         *      3 / 4 = 0       (3 and 4 are int literals)
         *      3.0 / 4 = 0.75  (3.0 is a double literal)
         */
        long totalMinutes = totalSeconds / SECONDS_FOR_EVERY_MINUTE;

        /*
         * Use the modulo (mod, remainder) operator to calculate how many seconds are leftover.
         * 
         *  The mod operator (%) returns the remainder of the division operation.
         *  
         *  It can be very useful when paired with integer division.
         *  
         *  For example:
         *      7 % 2 = 1
         *      11 % 3 = 2
         *      6 % 2 = 0
         *      4 % 11 = 4
         *      
         *  % 2 is frequently used to test odd/even (odd => 1; even => 0)
         */
        long seconds = totalSeconds % SECONDS_FOR_EVERY_MINUTE;

        long totalHours = totalMinutes / MINUTES_FOR_EVERY_HOUR;
        long minutes =  totalMinutes % MINUTES_FOR_EVERY_HOUR;

        long totalDays = totalHours / HOURS_FOR_EVERY_DAY;
        long hours = totalHours % HOURS_FOR_EVERY_DAY;

        long years = totalDays / DAYS_FOR_EVERY_YEAR;
        long days = totalDays % DAYS_FOR_EVERY_YEAR;

        System.out.println("Average time to crack: " + years + " years, " + days + " days, " +
            hours + " hours, " + minutes + " minutes, " + seconds +  " seconds");

        /*
         * A conversion is when a data value is converted from one type to another
         *      (e.g., int to a double, double to an int, int to a long).
         *      
         *  Widening: preserves information (e.g., int to a double, int to a long)
         *  Narrowing: lossy; may lose information (e.g., double to an int)
         *  
         *  Java only automatically performs widening conversions.
         *  
         *  This is a widening conversion:
         */
        double yearsAsDecimal = totalSeconds;

        /*
         * Arthimetic Promotion
         * 
         *  If the two operands are of different types, Java attempts to promote one of the types
         *      (widening conversion) and then perform the operation.
         *      
         *  In this case, SECONDS_FOR_EVERY_MINUTE and MINUTES_FOR_EVERY_HOUR are ints; so,
         *      Java doesn't perform any promotion and, instead, performs the multiplication and
         *      stores the result as an int. Only after all three multiplications does Java promote the
         *      int value of the resulting product to a long and then assign it to
         *      SECONDS_FOR_EVERY_YEAR.
         *      
         *  This promotion may be too late! If the multiplication overflows an int, the wrong value
         *      will be promoted to a long and stored.
         */
        final long SECONDS_FOR_EVERY_YEAR = SECONDS_FOR_EVERY_MINUTE * MINUTES_FOR_EVERY_HOUR *
            HOURS_FOR_EVERY_DAY * DAYS_FOR_EVERY_YEAR;

        /*
         * In this example, the value of SECONDS_FOR_EVERY_YEAR is promoted to a double and then
         *      floating-point division is performed and assigned to yearsAsDecimal.
         *  
         *  The local variable SECONDS_FOR_EVERY_YEAR is still a long and still has the same value.
         */
        yearsAsDecimal = yearsAsDecimal / SECONDS_FOR_EVERY_YEAR;

        System.out.println("or " + yearsAsDecimal + " years");

        /*
         * To force a narrowing conversion, use the cast operator.
         *      A cast is the "I know what I'm doing; trust me" conversion.
         *  
         *  (int)(84.69) => truncated to an int with a value of 84
         *  
         *  If we want to round a double to the nearest int, use the Math.round method:
         *      public static long round(double value)
         *  
         *  The following divides yearsAsDecimal by 10 (floating-point division), then rounds the
         *      resulting double to the nearest decade, and then casts the resulting long to an int.
         */
        int decades = (int)(Math.round(yearsAsDecimal / 10));
        System.out.println("or about " + decades + " decades");
    }

    /**
     * Compresses the specified keyphrase by removing all duplicate letters.
     * 
     * @param keyphrase     the keyphrase to compress
     * @return              the keyphrase with all duplicate letters removed
     */
    public static String compressKeyphrase(String keyphrase)
    {
        String compressedKeyphrase = "";

        /*
         * length
         *       returns the number of characters in the string
         */
        int keyphraseLength = keyphrase.length();

        for(int i = 0; i < keyphraseLength; i++)
        {
            /*
             * charAt
             *       returns the character (of type char) at the specified index (0-based)
             *       
             *  keyphrase:
             *  C A E S A R
             *  0 1 2 3 4 5     <= indicies
             *  
             *  length = 6
             */
            char letter = keyphrase.charAt(i);
            
            /*
             * substring
             *      returns part of the string starting at the first index and up to,
             *          but not including, the second index
             *      if only one index is specified, returns part of the string starting at the
             *          index through the end of the string
             *      substring does not support negative indicies
             *          For example, instead of -2, specify keyphrase.length()-2 as the argument 
             *          
             *  keyphrase:
             *  C A E S A R
             *  0 1 2 3 4 5     <= indicies
             *  
             *  length = 6
             */
            String restOfKeyphrase = keyphrase.substring(i + 1);
            // equivalent to: keyphrase.substring(i + 1, keyphrase.length())
            
            /*
             * indexOf
             *      returns the index of the start of the first occurrence of the specified string
             *      if not found, returns -1
             *      
             *  restOfKeyphrase:
             *  A E S A R
             *  0 1 2 3 4       <= indicies
             *  
             *  length = 5
             */
            int index = restOfKeyphrase.indexOf(letter);
            
            /*
             * String concatenation
             *      + is the string concatentation operator
             *      concatenates the second string operand to the end of the first string operand
             *      if one or both operands are String types, + is the string concatenation operator
             *          (operands are converted to Strings); otherwise, + is the addition operator
             *          
             *  int x = 7;
             *  String xAsString = "" + x;      // xAsString => "7"
             */
            if(index == -1)     // if a duplicate letter was not found
            {
                compressedKeyphrase = compressedKeyphrase + letter;
                // same as: compressedKeyphrase += letter;
            }
        }
        
        return compressedKeyphrase;
    }

    
    /**
     * Encrypts the specified text using the specified keyphrase using a
     *      keyphrase-enhanced Caesar Cipher.
     *      
     *  @param  text        the text to encrypt
     *  @param  keyphrase   the keyphrase with which to encrypt the specified text
     *  @return             the encrypted text
     */
    public static String encrypt(String text, String keyphrase)
    {
        String encryptedText = "";

        /*
         * The keyphrase, after removing any repeated letters is used as the beginning of the
         *      jumbled cipher alphabet. The remainder of the cipher alphabet is merely the
         *      remaining letters of the alphabet, in their correct order, starting where the
         *      keyphrase ends.
         */
        String cipherAlphabet = keyphrase;
        for(int i = 0; i < CaesarCipher.ALPHABET.length(); i++)
        {
            char letter = CaesarCipher.ALPHABET.charAt(i);
            if(keyphrase.indexOf(letter) == -1)
            {
                cipherAlphabet += letter;
            }
        }

        /*
         * For each letter in the text that is a letter, find the corresponding letter
         *      at the same position in the cipher alphabet as its replacement.
         */
        for(int i = 0; i < text.length(); i++)
        {
            char letter = text.charAt(i);

            // if the letter is between A and Z
            if(letter >= 'A' && letter <= 'Z')
            {
                // 65 is the ASCII value of 'A'
                int cipherIndex = letter - 65;
                encryptedText += cipherAlphabet.charAt(cipherIndex);
            }
            else    // don't substitute the letter; just use it as is
            {
                encryptedText += letter;
            }
        }

        return encryptedText;
    }

    /**
     * Calculates the average time to crack the cipher, based on the
     *      specified length of the keyphrase and seconds to evaluate
     *      each attempt, using a brute force approach. This calculation
     *      assumes that the cracker knows the length of the keyphrase.
     *      If the length is not know, it will take substantially longer
     *      to crack the cipher. Regardless, this calculation is only
     *      for a brute force approach; other techniques (e.g., frequency
     *      analysis) can crack the cipher extremely quickly.
     *      
     *  @param  keyphraseLength the number of characters in the keyphrase
     *  @param  secPerGuess     the number of seconds to evaluate each attempt
     *  @return                 the average number of seconds to crack the cipher
     */
    public static long calculateAverageTimeToCrack(int keyphraseLength, int secPerGuess)
    {
        final int NUMBER_OF_LETTERS_IN_ALPHABET = 26;
        int lettersRemaining = NUMBER_OF_LETTERS_IN_ALPHABET;
        long combinations = 1;

        /*
         * Calculate the number of combintations for the specified keyphrase length.
         *  For example, if the keyphrase is six characters long:
         *      26 * 25 * 24 * 23 * 22 * 21
         *      would be the number of combinations of cipher alphabets for keyphrases
         *      that are six characters long.
         */
        for(int i = 0; i < keyphraseLength; i++)
        {
            combinations *= lettersRemaining;
            lettersRemaining -= 1;
        }

        long worstCaseTimeToCrack = combinations * secPerGuess;

        // average time is half the worst time since the best time is cracking the
        //  cipher on the first attempt
        return worstCaseTimeToCrack / 2;
    }
}
