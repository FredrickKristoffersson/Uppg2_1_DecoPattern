public class QuantityDiscount extends BaseDiscount {

    public QuantityDiscount(Discount nextDiscount) {
        super(nextDiscount);
    }

    @Override
    protected boolean isApplicable(Product product) {
        return product.quantity() >= 5;
    }

    @Override
    protected double calculateDiscount(Product product) {
        // 10 kr rabatt per produkt vid köp av 5 varor eller mer
        return 10 * product.quantity();
    }

    @Override
    protected String getDiscountDescription() {
        return "10 kr rabatt per produkt vid köp av minst 5";
    }
}
