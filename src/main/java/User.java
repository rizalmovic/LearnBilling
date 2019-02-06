import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.EnumMap;

class User {

    public enum Gender {
        MALE,
        FEMALE
    }

    public enum Type {
        EMPLOYEE,
        AFFILIATE,
        OLDCUSTOMER
    }

    private String name;
    private Gender gender;
    private LocalDate joined_at;
    private boolean isEmployee = false;
    private boolean isAffiliate = false;
    private EnumMap<Type, Double> discounts;

    User(String name, Gender gender, String joined_at, boolean isEmployee, boolean isAffiliate) {
        this.name = name;
        this.gender = gender;
        this.joined_at = LocalDate.parse(joined_at, DateTimeFormatter.ISO_LOCAL_DATE);
        this.setupDiscounts();

        if(isEmployee) {
            this.isEmployee = true;
        }

        if(isAffiliate) {
            this.isAffiliate = true;
        }
    }

    private final void setupDiscounts() {
        this.discounts = new EnumMap<Type, Double>(Type.class);
        this.discounts.put(Type.EMPLOYEE, 0.3);
        this.discounts.put(Type.AFFILIATE, 0.1);
        this.discounts.put(Type.OLDCUSTOMER, 0.05);
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    void setGender(Gender gender) {
        this.gender = gender;
    }

    Gender getGender() {
        return this.gender;
    }

    void setJoined_at(String joined_at) {
        this.joined_at = LocalDate.parse(joined_at, DateTimeFormatter.ISO_LOCAL_DATE);
    }

    LocalDate getJoinedAt() {
        return this.joined_at;
    }

    void setAsEmployee(boolean status) {
        this.isEmployee = status;
    }

    boolean getIsEmployee() {
        return this.isEmployee;
    }

    void setAsAffiliate(boolean status) {
        this.isAffiliate = status;
    }

    boolean getIsAffiliate() {
        return this.isAffiliate;
    }

    public double getDiscount() {
        if(this.isEmployee) {
            return this.discounts.get(Type.EMPLOYEE);
        } else if(this.isAffiliate) {
            return this.discounts.get(Type.AFFILIATE);
        } else if (this.getJoinedAt().until(LocalDate.now(), ChronoUnit.YEARS) >= 2) {
            return this.discounts.get(Type.OLDCUSTOMER);
        }

        return 0.0;
    }
}