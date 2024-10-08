public abstract class BaseDiscount implements Discount {
    protected Discount nextDiscount;

    public BaseDiscount(Discount nextDiscount) {
        this.nextDiscount = nextDiscount;
    }

    protected abstract boolean isApplicable(Product product);
    protected abstract double calculateDiscount(Product product);

    @Override
    public double apply(Product product) {
        if (isApplicable(product)) {
            double discount = calculateDiscount(product);
            double nextDiscountAmount = nextDiscount != null ? nextDiscount.apply(product) : 0;
            return discount + nextDiscountAmount;
        } else if (nextDiscount != null) {
            return nextDiscount.apply(product);
        }
        return 0;
    }

    @Override
    public String getDescription(Product product) {
        String description = "";
        if (isApplicable(product)) {
            description = getDiscountDescription();
        }
        if (nextDiscount != null) {
            description += " " + nextDiscount.getDescription(product);
        }
        return description.trim();
    }

    protected abstract String getDiscountDescription();
}
