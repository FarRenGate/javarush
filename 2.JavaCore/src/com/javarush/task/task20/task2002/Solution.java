package com.javarush.task.task20.task2002;

import java.io.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = new File("C:/tmp/testObject.txt");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);

            JavaRush javaRush = new JavaRush();
            User user1 = new User();
            user1.setCountry(User.Country.UKRAINE);
            user1.setFirstName("Petya");
            user1.setLastName("Petin");
            user1.setMale(true);
            user1.setBirthDate(formatter.parse("18.01.1990"));
            User user2 = new User();
            user2.setCountry(User.Country.RUSSIA);
            user2.setFirstName("Manya");
            user2.setLastName("Manina");
            user2.setMale(false);
            user2.setBirthDate(formatter.parse("18.01.1992"));
            javaRush.users.add(user1);
            javaRush.users.add(user2);
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            System.out.println(javaRush.equals(loadedObject));
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
            PrintWriter writer = new PrintWriter(outputStream);
            writer.println(String.valueOf(users!=null));
            if (users!=null) {
                writer.println(users.size());
          //      writer.flush();
                for (User u: users) {
                    writer.println(u.getFirstName());
                    writer.println(u.getLastName());
                    if (u.getBirthDate()!=null) {
                        writer.println(formatter.format(u.getBirthDate()));
                    }
                    else {
                        writer.println("null");
                    }
                    writer.println(u.isMale());
                    writer.println(u.getCountry());
    //                writer.flush();
                }
            }
  //          writer.flush();
            writer.close();

//implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            if (reader.readLine().equals("true")) {
                int userSize=Integer.parseInt(reader.readLine());
                List<User> users = new ArrayList<>();

                String s;
                for (int i=0; i<userSize; i++) {
                    User user = new User ();
                    s=reader.readLine();
                    if (s.equals("null")) {
                        user.setFirstName(null);
                    }
                    else {
                        user.setFirstName(s);
                    }

                    s=reader.readLine();
                    if (s.equals("null")) {
                        user.setLastName(null);
                    }
                    else {
                        user.setLastName(s);
                    }

                    s=reader.readLine();
                    if (s.equals("null")) {
                        user.setBirthDate(null);
                    }
                    else {
                        user.setBirthDate(formatter.parse(s));
                    }

                    s=reader.readLine();
                    if (s.equals("true")) {
                        user.setMale(true);
                    }
                    else {
                        user.setMale(false);
                    }

                    s=reader.readLine();
                    switch (s) {
                        case "UKRAINE":
                            user.setCountry(User.Country.UKRAINE); break;
                        case "RUSSIA":
                            user.setCountry(User.Country.RUSSIA); break;
                        case "OTHER":
                            user.setCountry(User.Country.OTHER); break;
                        default:
                            user.setCountry(null); break;
                    }
                    users.add(user);

                }
                this.users=users;
                reader.close();

            }
            //implement this method - реализуйте этот метод
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
