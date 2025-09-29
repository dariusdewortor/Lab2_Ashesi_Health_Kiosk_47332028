import java.util.Scanner;

public class HealthKiosk {
    public static void main(String[] args) {
        // declaring and initializing variables
        char serviceCode;
        int healthMetric;
        String chosenHealthMetric = "";
        double weight;
        double height;
        double bmi;
        double roundedBmi = 0;
        String category = "";
        double dosage = 0;
        int numOfTablets = 0;
        double angleInDegrees;
        double angleInRadians;
        double sinValue;
        double cosValue;
        double roundedSin = 0;
        double roundedCos;
        String firstName;
        int integerBMI = 0;
        String code = "";
        Scanner input = new Scanner(System.in);
        System.out.println("Hello, Welcome to the Ashesi Health Kiosk!"); // welcome message
        // Task 1
        System.out.println("Enter service code P/L/T/C: "); // prompting user to enter service code
        serviceCode = Character.toUpperCase(input.next().charAt(0)); // accepting service code from user
        // using the switch statements to select output that matches with users entery
        switch (serviceCode) {
            case 'P':
                System.out.println("Go to: Pharmacy");
                break;
            case 'L':
                System.out.println("Go to: Lab");
                break;
            case 'T':
                System.out.println("Go to: Triage");
                break;
            case 'C':
                System.out.println("Go to: Councelling");
                break;
            default:
                System.out.println("Invalid service code"); // prints when no valid input is given
        }
        // Task 2
        // using switch to allow user to choose between options
        if (serviceCode == 'T') {
            System.out.println(" Enter 1 for BMI, 2 for Dosage round-up, 3 for simple trig helper");
            healthMetric = input.nextInt();
            switch (healthMetric) {
                case 1:
                    chosenHealthMetric = "Checking BMI";
                    break;
                case 2:
                    chosenHealthMetric = "Dosage round up";
                    break;
                case 3:
                    chosenHealthMetric = "Trig helper";
            }
            if (chosenHealthMetric.equals("Checking BMI")) {
                System.out.println("Enter your weight: ");
                weight = input.nextDouble();
                System.out.println("Enter your height: ");
                height = input.nextDouble();
                bmi = weight / (Math.pow(height, 2));
                roundedBmi = Math.round(bmi * 10) / 10.0;

                System.out.println("Your BMI is " + roundedBmi);
                if (roundedBmi < 18.5) {
                    category = "Underweight";
                } else if (roundedBmi >= 18.5 && roundedBmi < 24.9) {
                    category = "Normal";
                } else if (roundedBmi >= 25.0 && roundedBmi < 29.9) {
                    category = "Overweight";
                } else if (roundedBmi > 30.0) {
                    category = "Obese";
                }
                System.out.println("Category: " + category);
            }

            if (chosenHealthMetric.equals("Dosage round up")) {
                System.out.println("Enter required dosage mg: ");
                dosage = input.nextDouble();
                numOfTablets = (int) Math.ceil(dosage / 250);
                System.out.println("Number of tablets to be dispensed is " + numOfTablets);
            }
            if (chosenHealthMetric.equals("Trig helper")) {
                System.out.println("Enter angle in degrees: ");
                angleInDegrees = input.nextDouble();
                angleInRadians = Math.toRadians(angleInDegrees);
                sinValue = Math.sin(angleInRadians);
                cosValue = Math.cos(angleInRadians);
                roundedSin = Math.round(sinValue * 1000) / 1000.0;
                roundedCos = Math.round(cosValue * 1000) / 1000.0;
                System.out.println("The sin and cos of angle " + angleInDegrees + " are " + roundedSin + " and "
                        + roundedCos + " respectively");

            }

        }
        // Task 3
        // generating random numbers and a random character
        char randomCharacter = (char) ((int) (Math.random() * 26) + 'A');
        int randomNumber1 = (int) (Math.random() * 10);
        int randomNumber2 = (int) (Math.random() * 10);
        int randomNumber3 = (int) (Math.random() * 10);
        int randomNumber4 = (int) (Math.random() * 10);
        String ID = randomCharacter + "" + randomNumber1 + randomNumber2 + randomNumber3 + randomNumber4;
        if (ID.length() == 5) {

            if (Character.isLetter(ID.charAt(0))) {
                if (Character.isDigit(ID.charAt(1)) &&
                        Character.isDigit(ID.charAt(2)) &&
                        Character.isDigit(ID.charAt(3)) &&
                        Character.isDigit(ID.charAt(4))) {
                    System.out.println("ID OK");

                } else {
                    System.out.println("Characters 1–4 must all be digits.");
                }

            } else {
                System.out.println("First character must be a letter.");
            }

        } else {
            System.out.println("ID must be exactly 5 characters long.");
        }

        // Task 4
        System.out.println("Enter your first name: ");
        input.nextLine();
        firstName = input.nextLine();
        char base = Character.toUpperCase(firstName.charAt(0));
        char shifted = (char) ('A' + (base - 'A' + 2) % 26);
        String lastTwoID = ID.substring(ID.length() - 2);
        int integerroundedSin = (int) roundedSin;
        if (chosenHealthMetric.equals("Dosage round up")) {
            code = "" + shifted + lastTwoID + numOfTablets;
            System.out.println(code);
        } else if (chosenHealthMetric.equals("Trig helper")) {
            code = "" + shifted + lastTwoID + integerroundedSin;
            System.out.println(code);
        } else if (chosenHealthMetric.equals("Checking BMI")) {
            integerBMI = (int) roundedBmi;
            code = "" + shifted + lastTwoID + integerBMI;
            System.out.println(code);
        }

        // Task 5
        switch (serviceCode) {
            case 'P':
                System.out.println("PHARMACY" + "|" + "ID=" + ID + "|"  + "Code=" + code);
                break;
            case 'L':
                System.out.println("LAB" + "|" + "ID=" + ID + "|" + "Code=" + code);
                break;
            case 'T':
                if (chosenHealthMetric.equals("Dosage round up")) {
                    System.out.println("TRIAGE" + "|" + "ID=" + ID + "|" + "Dosage=" + dosage + "|" + "Code=" + code);
                } else if (chosenHealthMetric.equals("Checking BMI")) {
                    System.out.println("TRIAGE" + "|" + "ID=" + ID + "|" + "BMI=" + integerBMI + "|" + "Code=" + code);
                } else if (chosenHealthMetric.equals("Trig helper")) {
                    System.out.println(
                            "TRIAGE" + "|" + "ID=" + ID + "|" + "Sin of angle=" + roundedSin + "|" + "Code=" + code);
                }
                break;
            case 'C':
                System.out.println("COUNCELLING" + "|" + "ID=" + ID + "|" + "Code=" + code);
                break;
            default:
                System.out.println("Invalid service code");
        }

    }
}