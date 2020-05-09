package bcxhxckhxc;

public class Main {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        System.out.println(myDog);

        Settable<Dog> s = (obj, name, age) -> {
            obj.setName(name);
            obj.setAge(age);
        };

        changeEntity(myDog, s);

        System.out.println(myDog);
    }

    private static <T extends WithNameAndAge> void changeEntity(T entity, Settable<T> s){
        s.set(entity, "Кузя", 5);
    }

    interface WithNameAndAge{
        void setName(String name);
        void setAge(int age);
    }

    interface Settable<c extends WithNameAndAge>{
        void set (c entity, String name, int age);
    }

    static class Dog implements WithNameAndAge{
        private String name;
        private int age;

        @Override
        public void setName (String name){
            this.name = name;
        }

        @Override
        public void setAge (int age){
            this.age = age;
        }

        @Override
        public String toString() {
            return "Dog{" + "name= " + name + '\'' + "age= " + age + '}';

        }
    }
}