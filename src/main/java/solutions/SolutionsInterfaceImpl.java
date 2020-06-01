package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SolutionsInterfaceImpl implements SolutionsInterface {
    /**
     * Search Email in text:
     * Assume easy case:
     * Email structure:
     * (login)@(subdomain).(domain);
     * 1. (login) & (subdomain) consists of literals, digits, "_", "-" and dots;
     * 2. a "@" symbol;
     * 3. a dot symbol;
     * 4. (domain) consists of 2 up to 6 symbols;
     *
     * @param text - text to find emails in;
     * @return list of valid emails.
     */
    public List<String> firstTaskEasy(String text) {
        List<String> answers = new ArrayList<>();
        Pattern regEx = Pattern.compile("([a-z]|\\d|_|-|\\.)+@([a-z]|\\d|_|-|\\.)+\\.([a-z]|\\.){2,6}",
                Pattern.CASE_INSENSITIVE);
        Matcher isEmail = regEx.matcher(text);
        while (isEmail.find()) {
            answers.add(text.substring(isEmail.start(), isEmail.end()));
        }
        return answers;
    }

    /**
     * Search Email in text:
     * Basically, similar to firstTaskEasy(String text), see it's javaDoc;
     * Go to https://help.returnpath.com/hc/en-us/articles/220560587-What-are-the-rules-for-email-address-syntax-
     * for more info;
     *
     * @param text - text to find email in;
     * @return list of valid emails.
     */
    public List<String> firstTaskMedium(String text) {
        List<String> answers = new ArrayList<>();
        Pattern regEx = Pattern.compile("([a-z]|\\d)([^!#$%&'*+-=?^_`{|]{2,})+([a-z]|\\d)@([a-z]|[A-Z]|\\d|\\.|-)+\\.\\S+",
                Pattern.CASE_INSENSITIVE);
        Matcher isEmail = regEx.matcher(text);
        while (isEmail.find()) {
            answers.add(text.substring(isEmail.start(), isEmail.end()));
        }
        return answers;
    }

    /**
     * Search email in "text" String using regEx from http://emailregex.com/;
     *
     * @param text - text to find email in;
     * @return list of valid emails.
     */
    public List<String> firstTaskHard(String text) {
        List<String> answers = new ArrayList<>();
        Pattern regEx = Pattern.compile(
                "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-" +
                        "\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09" +
                        "\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?" +
                        "\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|" +
                        "[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|" +
                        "[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a" +
                        "\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)])", Pattern.CASE_INSENSITIVE);
        Matcher isEmail = regEx.matcher(text);
        while (isEmail.find()) {
            answers.add(text.substring(isEmail.start(), isEmail.end()));
        }
        return answers;
    }

    /**
     * Search URL in text:
     * URL structure:
     * (unnecessary {http://} or {https://})(domain levels 1+)(domain level 0)(file system)/(unnecessary {/})
     * 1. "http://" or "https://" or "";
     * 1. (domains levels 1+) consists of literals, digits, "_", "-" and dots;
     * 2. (domain level 0) consists of 2 up to 6 symbols of literals or dots;
     * 3. (file system) consists of literals, digits, "_", "-" and dots;
     * 4. a "/";
     * 5. a "/" or "";
     *
     * @param text - text to find URLs in;
     * @return list of valid URLs.
     */
    public List<String> secondTaskEasy(String text) {
        List<String> answers = new ArrayList<>();
        Pattern regEx = Pattern.compile("(http://|https://)?([a-z]|\\d|-|_|\\.)+([a-z]|\\.){2,6}([a-z]|\\d|-|_|\\.)+/(/)?",
                Pattern.CASE_INSENSITIVE);
        Matcher isURL = regEx.matcher(text);
        while (isURL.find()) {
            answers.add(text.substring(isURL.start(), isURL.end()));
        }
        return answers;
    }

    /**
     * Search URL in text using regEx from https://urlregex.com/
     *
     * @param text - text to find URLs in;
     * @return list of valid URLs.
     */
    public List<String> secondTaskHard(String text) {
        List<String> answers = new ArrayList<>();
        Pattern regEx = Pattern.compile("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]",
                Pattern.CASE_INSENSITIVE);
        Matcher isURL = regEx.matcher(text);
        while (isURL.find()) {
            answers.add(text.substring(isURL.start(), isURL.end()));
        }
        return answers;
    }

    /**
     * Search IP address in text:
     * Assume Ip Address has following structure:
     * (numberGroup).(x3)(numberGroup);
     * 1. (numberGroup) is either a:
     * a. 3-digit number, < 256;
     * b. 2-digit number, < 99;
     * c. a digit;
     *
     * @param text - text to find IPs in;
     * @return list of valid IPs.
     */
    public List<String> thirdTaskEasy(String text) {
        List<String> answers = new ArrayList<>();
        Pattern regEx = Pattern.compile("((((1[0-9][0-9])|(2([0-4][0-9])|(5[0-5])))|([1-9][0-9])|[0-9])\\.){3}" +
                "(((1[0-9][0-9])|(2([0-4][0-9])|(5[0-5])))|([1-9][0-9])|[0-9])", Pattern.CASE_INSENSITIVE);
        Matcher isIPAddress = regEx.matcher(text);
        while (isIPAddress.find()) {
            answers.add(text.substring(isIPAddress.start(), isIPAddress.end()));
        }
        return answers;
    }

    /**
     * Search IP address in text, using regEx from stackOverflow
     * @param text - text to find IPs in;
     * @return list of valid IPs.
     */
    public List<String> thirdTaskHard(String text) {
        List<String> answers = new ArrayList<>();
        Pattern regEx = Pattern.compile("^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}" +
                "([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$", Pattern.CASE_INSENSITIVE);
        Matcher isIPAddress = regEx.matcher(text);
        while (isIPAddress.find()) {
            answers.add(text.substring(isIPAddress.start(), isIPAddress.end()));
        }
        return answers;
    }

}
