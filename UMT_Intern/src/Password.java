public class Password {

    public int checkPassword(String password){
        System.out.println("You entered the password:"+password);
        int lowerCaseCounter = 0;
        int upperCaseCounter = 0;
        int digitCounter = 0;
        boolean threeConsecutive = false;
        int changes = 0;
        int counter = 0;
        int minimumLength = 6;
        int maximumLength = 20;

        for(int i =0; i<password.length(); i++){
            if(Character.isLowerCase(password.charAt(i))){
                lowerCaseCounter++;
            }
            if(Character.isUpperCase(password.charAt(i))){
                upperCaseCounter++;
            }
            if(Character.isDigit(password.charAt(i))){
                digitCounter++;
            }
        }

        for(int i=1; i<password.length();i++){
            char currentLetter = password.charAt(i);
            char previousLetter = password.charAt(i-1);
            if(currentLetter == previousLetter) {
                counter = counter + 1;
            }
        }

        if(counter >= 2){
            threeConsecutive = true;
        }

        if(password.length() >= minimumLength && password.length() <= maximumLength && lowerCaseCounter > 0 && upperCaseCounter > 0 && digitCounter > 0 && !threeConsecutive){
            System.out.println("Strong password");
        }else
        {
            System.out.println("Weak password");
        }

        if(password.length() < (minimumLength - 1)){
            changes = minimumLength - password.length();
        }

        if(password.length() > (maximumLength + 1)){
            changes = password.length() - maximumLength;
        }


        //MINIMUM LENGTH -1
        if(password.length() == (minimumLength - 1) && ((lowerCaseCounter == 0 && digitCounter ==0) || (upperCaseCounter == 0 && digitCounter ==0) || (lowerCaseCounter == 0 && upperCaseCounter == 0))){
            changes = minimumLength - password.length() + 1;
        }
        else if(password.length() == (minimumLength - 1) && ((lowerCaseCounter == 0) || (upperCaseCounter == 0) || (digitCounter == 0))){
            changes = changes + 1;
        }

        if(password.length() == (minimumLength - 1) && ((lowerCaseCounter > 0 && digitCounter > 0) || (upperCaseCounter > 0 && digitCounter > 0) || (lowerCaseCounter > 0 && upperCaseCounter > 0))){
            changes = minimumLength - password.length();
        }

        //MAXIMUM LENGTH + 1
        if(password.length() == (maximumLength +1) && ((lowerCaseCounter > 0 && upperCaseCounter > 0) || (lowerCaseCounter > 0 && digitCounter > 0) && (upperCaseCounter > 0 && digitCounter > 0))){
            changes = password.length() - maximumLength;
        }

        if(password.length() == (maximumLength + 1) && ((lowerCaseCounter == 0 && upperCaseCounter == 0) || (digitCounter == 0 && upperCaseCounter == 0) || (digitCounter == 0 && lowerCaseCounter == 0))){
            changes = password.length() - maximumLength + 2;
        }
        else if(password.length() == (maximumLength + 1) && ((lowerCaseCounter == 0) || (upperCaseCounter == 0) || (digitCounter == 0))){
            changes = password.length() - maximumLength + 1;
        }



        //MAXIMUM LENGTH
        if(password.length() == maximumLength && ((lowerCaseCounter > 0 && upperCaseCounter > 0 && digitCounter == 0) || (lowerCaseCounter > 0 && digitCounter > 0 && upperCaseCounter == 0) || (upperCaseCounter > 0 && digitCounter > 0 && lowerCaseCounter ==0))){
            changes = changes + 1;
        } else if(password.length() == maximumLength && ((lowerCaseCounter == 0 && digitCounter == 0) || (lowerCaseCounter == 0 && upperCaseCounter == 0) || (digitCounter == 0 && upperCaseCounter == 0))){
            changes = changes + 2;
        }


        //MINIMUM LENGTH
        if(password.length() == minimumLength && ((lowerCaseCounter > 0 && upperCaseCounter > 0 && digitCounter == 0) || (lowerCaseCounter > 0 && digitCounter > 0 && upperCaseCounter == 0) || (upperCaseCounter > 0 && digitCounter > 0 && lowerCaseCounter ==0))){
            changes = changes + 1;
        }
        else if(password.length() == minimumLength && ((lowerCaseCounter == 0 && digitCounter == 0) || (lowerCaseCounter == 0 && upperCaseCounter == 0) || (digitCounter == 0 && upperCaseCounter == 0))){
            changes = changes + 2;
        }


        //BETWEEN MINIMUM AND MAXIMUM
        if(password.length() > minimumLength && password.length() < maximumLength){
            if((lowerCaseCounter == 0 && upperCaseCounter == 0) || (lowerCaseCounter == 0 && digitCounter == 0) || (upperCaseCounter == 0 && digitCounter == 0)){
                changes = changes + 2;
            }
            else if(lowerCaseCounter == 0 || upperCaseCounter == 0 || digitCounter == 0) {
                changes = changes + 1;
            }
        }


        if(password.length() >= minimumLength && password.length() <= maximumLength && lowerCaseCounter > 0 && upperCaseCounter > 0 && digitCounter > 0 && threeConsecutive){
            changes = changes + 1;
        }
        System.out.println("The minimum changes:"+changes);
        return changes;
    }
}
