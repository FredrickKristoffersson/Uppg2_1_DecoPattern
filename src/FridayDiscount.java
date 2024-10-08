import java.time.DayOfWeek;
import java.time.LocalDate;

public class FridayDiscount extends BaseDiscount {

    public FridayDiscount(Discount nextDiscount) {
        super(nextDiscount);
    }

    @Override
    protected boolean isApplicable(Product product) {
        return LocalDate.now().getDayOfWeek() == DayOfWeek.FRIDAY;
    }

    @Override
    protected double calculateDiscount(Product product) {
        // 10% rabatt på vara
        return product.price() * 0.10;
    }

    @Override
    protected String getDiscountDescription() {
        return "10% rabatt för fredag";
    }
}
