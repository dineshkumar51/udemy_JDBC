package com.main;

import com.dao.UserDao;
import com.dao.UserDaoImplementation;
import com.model.Instructor;
import com.model.Learner;
import com.model.User;
import com.util.ScannerConnection;
import java.util.InputMismatchException;
import java.util.Scanner;


public class SignupLoginFlow {

    private static final UserDao userdao = new UserDaoImplementation();
    private LearnerFlow learnerFlow = null;
    private InstructorFlow instructorFlow = null;


    public void start() {
        Scanner sc = ScannerConnection.getScanner();

        while (true) {

            int check = 0;

            try {
                System.out.println();
                System.out.println("            1. LOGIN");
                System.out.println("            2. SIGNUP");
                check = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Enter a Valid option");
                sc.nextLine();
                continue;
            }

            if (check == 1) {
                User user = login();
                if (user instanceof Learner) {
                    learnerFlow = new LearnerFlow((Learner) user);
                    learnerFlow.start();
                } else if (user instanceof Instructor) {
                    instructorFlow = new InstructorFlow((Instructor) user);
                    instructorFlow.start();
                }
            } else if (check == 2) {
                signUp();
            } else {
                System.out.println("Enter a Valid option");
            }
        }
    }

    private User login() {
        Scanner sc = ScannerConnection.getScanner();
        boolean login_flag = true;
        User user = null;
        while (login_flag) {
            System.out.print("Enter your UserName : ");
            String username = sc.next();
            System.out.print("Enter your Password : ");
            String password = sc.next();

            user = userdao.getUser(username, "instructor");
            if (user == null) {
                user = userdao.getUser(username, "learner");
            }

            if (user == null) {
                System.out.println("Incorrect Username\n");
                continue;
            } else if (!user.getPassword().equals(password)) {
                System.out.println(user.getPassword());
                System.out.println("\nIncorrect Password\n");
                continue;
            }
            login_flag = false;
        }

        System.out.println("Welcome, " + user.getFullName());
        return user;

    }

    private void signUp() {
        Scanner sc = ScannerConnection.getScanner();
        boolean signUpFlag = true;
        int signUpOption = 0;
        while (signUpFlag) {
            try {
                System.out.println("            1.SignUp as User");
                System.out.println("            2.SignUp as Creator");

                signUpOption = sc.nextInt();
                if (signUpOption > 0 && signUpOption < 3) {
                    signUpFlag = false;
                }
                System.out.println("Enter a Valid option");
                System.out.println();
            } catch (InputMismatchException e) {
                System.out.println("Enter a Valid option");
                System.out.println();
                sc.nextLine();
            }

        }
        switch (signUpOption) {
            case 1 -> createAccount("learner");
            case 2 -> createAccount("instructor");
            default -> System.out.println("Enter a Valid option");
        }
    }

    private void createAccount(String type) {
        Scanner sc = ScannerConnection.getScanner();
        boolean createAccountFlag = true;
        while (createAccountFlag) {
            System.out.print("Enter your name : ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Enter userId : ");
            String username = sc.next();
            System.out.print("Enter password : ");
            String password = sc.next();
            System.out.print("Confirm password : ");
            String confirmPassword = sc.next();

            if (!password.equals(confirmPassword)) {
                System.out.println("Confirm password failed .... try again\n");
                continue;
            }

            User user = userdao.getUser(username, "instructor");
            if (user == null) {
                user = userdao.getUser(username, "learner");
                if (user == null) {
                    User newUser = null;
                    if (type == "instructor") {
                        newUser = new Instructor(username, name, password);
                    } else {
                        newUser = new Learner(username, name, password);
                    }
                    userdao.add(newUser, type);
                    System.out.println("Account Created Successfully");
                    createAccountFlag = false;
                } else {
                    System.out.println("Username already exists\n");
                    continue;
                }
            } else {
                System.out.println("Username already exists\n");
                continue;
            }
        }
    }
}
