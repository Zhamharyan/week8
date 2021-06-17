package Exceptions;

public class InvalidQuantityType extends CreatCommandException{
    @Override
    public String getMessage() {
        return "Invalid Quantity Type";
    }
}
