package kovynev.bl;

import kovynev.Entity.Entity;
import kovynev.jdbc.Service;
import kovynev.jdbc.Util;

import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static double usdNow = 0;
    public static void main(String[] args) {



        Timer timer = new Timer("Timer");
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Entity entity = createEntity();
                new Service().update(entity);
                strategy24_72();
            }
        };
        timer.scheduleAtFixedRate(timerTask,0,3600_000);


    }

    private static Entity createEntity() {
        Request request = new Request();
        Entity entity = new Entity();
        entity.setDateTime(request.getDateTime());
        entity.setUsdRub(request.getUsd_rub());
        return entity;
    }

    public static void strategy24_72(){
        Analyses analyses = new Analyses();
        Cash cash = Cash.create();
        if(analyses.canIBuyStrategy24_72()){
            cash.buyUSD(100,usdNow);
        }
    }
}
