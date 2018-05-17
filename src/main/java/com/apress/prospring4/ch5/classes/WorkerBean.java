package com.apress.prospring4.ch5.classes;


public class WorkerBean {

    public void doSomeWork(int noOfTime){
        for(int i=0;i<noOfTime;i++){
            work();
        }
    }
    private void work(){
        double sum = getNumbers() *(Math.random()*25.3);
        System.out.println(sum);
    }
    private double getNumbers(){
        return (Math.random()*200.2);
    }
}
