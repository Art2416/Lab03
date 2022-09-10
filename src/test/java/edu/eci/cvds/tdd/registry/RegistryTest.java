package edu.eci.cvds.tdd.registry;
import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {

    private Registry registry = new Registry();

    @Test
    public void validateRegistryValid() {

        Person person = new Person("David", 2469, 21, Gender.MALE, true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.VALID, result);
    }

    @Test
    public void validateRegistryDead(){
        Person person = new Person("Carlos", 7010, 63, Gender.MALE, false);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.DEAD, result);

    }

    @Test
    public void validateRegistryInvalidAge(){
        Person person = new Person("Diana", 5161, -1, Gender.FEMALE, true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }

    @Test
    public void validateRegistryUnderAge(){
        Person person = new Person("Juana", 7773, 10, Gender.UNIDENTIFIED, true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }

    @Test
    public void validateRegistryDuplicate(){
        Person person = new Person("David", 2469, 21, Gender.MALE, true);

        registry.registerVoter(person);
        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.DUPLICATED, result);
    }

    @Test
    public void validateRegistryFronterAgeMin(){
        Person person = new Person("Luis", 8376, -230, Gender.MALE, false);
        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }
}
