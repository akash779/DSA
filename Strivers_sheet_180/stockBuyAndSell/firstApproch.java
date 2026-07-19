class firstApproch {
    public int maxProfit(int[] prices) {
        int maxProfit =0;
        for(int i=0 ; i<prices.length ; i++){

            int buy=prices[i];
            for(int j=i ; j< prices.length ; j++){
                int sell = prices[j];
                int profit=0;
                if(buy<sell){profit=sell-buy;}
                if(maxProfit<profit)maxProfit=profit;

                

            }

        }
            return maxProfit;
        
    }
}
