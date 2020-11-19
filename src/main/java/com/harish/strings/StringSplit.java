package com.harish.strings;

public class StringSplit {

    public static void main(String[] arg) {
        String level = "A";
        //String levelNameSplit[] = level.split("(?<=\\D)(?=\\d)");

        //String levelName = levelNameSplit.length==1?((Integer.toString(Integer.parseInt(levelNameSplit[0]) + 1))):levelNameSplit[0] + (Integer.parseInt(levelNameSplit[1]) + 1);

       // if(levelNameSplit.length == 1) {

        //}
        //System.out.println(levelNameSplit[0] + "  " + levelNameSplit[0]);
        //System.out.println(levelName);
        System.out.println(level.charAt(level.length() - 1 ));

       // if(Character.isLetter(level.charAt(level.length() -1))) {
      //      System.out.println(Character.toChars(level.charAt(level.length() -1) - 1));
     //   }

        String levelName;
        levelName = level.substring(0, level.length() - 1) + (char) (level.charAt(level.length() - 1) - 1);
        System.out.println(levelName);

    }
}
