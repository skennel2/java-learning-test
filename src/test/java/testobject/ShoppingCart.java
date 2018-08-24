package testobject;

import java.util.List;

public class ShoppingCart implements Comparable<ShoppingCart>{
    private List<String> merchandiseList;
        
    public ShoppingCart(List<String> merchandiseList) {
        this.merchandiseList = merchandiseList;
    }

    public int getItemCount() {
        return merchandiseList.size();
    }
    
    public void addItem(String merchandise) {
        merchandiseList.add(merchandise);
    }

    @Override
    public int compareTo(ShoppingCart cart) {        
        if(getItemCount() > cart.getItemCount()) {
            return 1;
        }else if(getItemCount() < cart.getItemCount()) {
            return -1;
        }
        else {
            return 0;
        }              
    }
}
