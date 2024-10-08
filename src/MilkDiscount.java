public class MilkDiscount extends BaseDiscount {

    public MilkDiscount(Discount nextDiscount) {
        super(nextDiscount);
    }

    @Override
    protected boolean isApplicable(Product product) {
        return product.name().equalsIgnoreCase("mjölk");
    }

    @Override
    protected double calculateDiscount(Product product) {
       // 5% rabatt på vara
        return product.price() * 0.05;
    }

    @Override
    protected String getDiscountDescription() {
        return "5% rabatt på mjölk";
    }
}
