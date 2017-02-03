package com.javarush.test.level17.lesson04.task04;

/* Синхронизированный президент
И снова Singleton паттерн - синхронизация в статическом блоке
Внутри класса OurPresident в статическом блоке создайте синхронизированный блок.
Внутри синхронизированного блока инициализируйте president.
*/

public class Solution {
    public static class OurPresident {

        static
        {
            synchronized (OurPresident.class) //When we create a synchronized block in a static method, we need to synchronize on an object, so what object should we synchronize on? We can synchronize on the Class object that represents the class that is being synchronized.
            {
                president = new OurPresident();
            }
        }

        private static OurPresident president;

        private OurPresident() {
        }

        public static OurPresident getOurPresident() {
            return president;
        }
    }
}
