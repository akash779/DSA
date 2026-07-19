public class optimalApproch {
    public int maxProfit(int[] prices){

        int minPrice = Integer.MAX_VALUE;
        int maxProfit =0;

        for(int i=0 ; i<prices.length ; i++){

            //is today is the minPrice of past
            if(minPrice>prices[i])minPrice = prices[i];
            
            //do we get maximum profit if i sell today on the past minPrice ??
            if(maxProfit<prices[i]-minPrice){maxProfit=prices[i]-minPrice;}


        }
        return maxProfit;
    }
    
}
