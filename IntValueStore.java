package com.example.animation;

public class IntValueStore {
    int val=1;
   // int prev_val=-1;
    private ValueStoreListener valListener;

    public IntValueStore(){}
    public int getVal(){return val;}

    public void setVal(int val) {
        this.val = val;

        if(valListener!=null){
            valListener.onChange();
        }
    }

    public ValueStoreListener getValListener() {
        return valListener;
    }

    public void setValListener(ValueStoreListener valListener) {
        this.valListener = valListener;
    }

    public interface ValueStoreListener{
        void onChange();
    }

}

