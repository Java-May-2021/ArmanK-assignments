public class StringManipulator{

        /* Using the trim and concat method of String class  */

        public String trimAndConcat(String string1, String string2){
            return string1.trim().concat(string2.trim());
        }

        /* Using the indexOf method of String class  */

        public Integer getIndexOrNull(String string1, char char1){
            if(string1.indexOf(char1) == -1){
                return null;
            }
            else{
                return string1.indexOf(char1);
            }
        }

        public Integer getIndexOrNull(String string1, String substring){
               if(string1.indexOf(substring) == -1){
                return null;
            }
            else{
                return string1.indexOf(substring);
            }
        }

        /* Using the concatSubstring method of String class  */

        public String concatSubstring(String givenString, int startIndex, int endIndex, String concatString){
            String newStr = givenString.substring(startIndex, endIndex);
            return newStr.concat(concatString);

        }
}
