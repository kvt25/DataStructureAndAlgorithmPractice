/*
An email address such as "John.Smith@example.com" is made up of a local part ("John.Smith"), an "@" symbol, then a domain part ("example.com").

The domain name part of an email address may only consist of letters, digits, hyphens and dots. The local part, however, also allows a lot of different special characters. Here you can look at several examples of correct and incorrect email addresses.

Given a valid email address, find its domain part.

Example

For address = "prettyandsimple@example.com", the output should be
findEmailDomain(address) = "example.com";
For address = "<>[]:,;@"!#$%&*+-/=?^_{}| ~.a"@example.org", the output should be
findEmailDomain(address) = "example.org".
Input/Output

[execution time limit] 3 seconds (kt)

[input] string address

Guaranteed constraints:
10 ≤ address.length ≤ 50.

[output] string


Test case 1:
Input:
address: "prettyandsimple@example.com"
Expected Output:
"example.com"

Test case 2:
Input:
address: "<>[]:,;@\"!#$%&*+-/=?^_{}| ~.a\"@example.org"
Expected Output:
"example.org"

Test case 3:
Input:
address: "someaddress@yandex.ru"
Expected Output:
"yandex.ru"

Test case 4:
Input:
address: "\" \"@xample.org"
Expected Output:
"xample.org"
 */
package org.algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class FindEmailDomainPart {
    public static void main(String[] args) {
        String input = "@xample.com";
        Set<Character> allowedCharacter = initializeAllowedCharacters();
        System.out.println(checkValidDomainPart(input, allowedCharacter));
    }

    private static boolean checkValidDomainPart(String input, Set<Character> allowedCharacter) {
        String[] arr = input.split("@");

        if(arr.length <= 1) {
            return false;
        }
        String domainPart = arr[arr.length - 1];

        return Arrays.asList(domainPart.toCharArray()).stream().allMatch(c -> allowedCharacter.contains(c));
    }

    private static Set<Character> initializeAllowedCharacters() {
        Set<Character> allowedChars = new HashSet<>();
        //Letters
        for(int i = 97; i <= 122; i++) {
            allowedChars.add((char) i);
        }

        //Digits
        for(int i = 48; i <= 57; i++) {
            allowedChars.add((char) i);
        }

        //'-', '.'
        allowedChars.add('-');
        allowedChars.add('.');

        return allowedChars;
    }
}
