package DesignPatterns;

public class Singleton {

    public static void main(String[] args) {
        Samosa s1 = Samosa.getSamosa();
        Samosa s2 = Samosa.getSamosa();
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        Samosa s3 = Samosa.threadSafeSamosa();
        Samosa s4 = Samosa.threadSafeSamosa();
        System.out.println(s3.hashCode());
        System.out.println(s4.hashCode());

        Samosa s5 = Samosa.threadSafeSamosa2();
        Samosa s6 = Samosa.threadSafeSamosa2();
        System.out.println(s5.hashCode());
        System.out.println(s6.hashCode());

        Jalebi j1 = Jalebi.getJalebi();
        Jalebi j2 = Jalebi.getJalebi();
        System.out.println(j1.hashCode());
        System.out.println(j2.hashCode());
    }
}

// Lazy initialization
class Samosa {
    private static Samosa samosa;
    private Samosa() {
        if(samosa != null) {
            throw new RuntimeException("You are not allowed to create more than one object of singleton class Samosa since it will break the singleton pattern");
        }
    }

    // Eager initialization without thread safety
    public static Samosa getSamosa() {
        if (samosa == null) {
            samosa = new Samosa();
        }
        return samosa;
    }

    // Thread Safe by implementing block synchronization
    public static Samosa threadSafeSamosa() {
        if (samosa == null) {
            synchronized (Samosa.class) {
                if (samosa == null) {
                    samosa = new Samosa();
                }
            }
        }
        return samosa;
    }
    

    // Thread safe by implementing method synchronization
    public synchronized static Samosa threadSafeSamosa2() {
        if (samosa == null) {
            samosa = new Samosa();
        }
        return samosa;
    }
}


// Eager initialization
class Jalebi{
    private static Jalebi jalebi = new Jalebi();

    private Jalebi() {
    }

    public static Jalebi getJalebi() {
        return jalebi;
    }
}

/*
 * Steps to create Singleton class:
 * 
 * 1. Create a private constructor
 * 2. Create a static variable
 * 3. Create a static method
 * 4. Create an instance of the class
 * 
 * use cases : 
 * 1. Database Connection
 * 2. File Handle
 * 3. Thread Safe
 * 
 */