package com.example.attrtest;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.lang.reflect.Type;

public class MyCustomView extends View {
    private static final String TAG="AttrLog";
    // 若动态构造,则属性默认是主题属性
    public MyCustomView(Context context){
        this(context,null);
    }

    // 若有set,则说明是从xml中构造,那么加上theme中给定的custom_style
    public MyCustomView(Context context, AttributeSet set){
        this(context,set,R.attr.custom_style);
    }

    // 若有set,则说明是从xml中构造,加上指定的theme中给定的custom_style作为defStyle,再加上其他给定的defStyleRes
    // 要获取的属性集即由R.styleable.custom_attrs指定,即color1到color5
    // 从实际获取到的属性可以得到优先级
    public MyCustomView(Context context,AttributeSet set,int defStyle){
        super(context,set,defStyle);
        final TypedArray a=context.obtainStyledAttributes(
                set,R.styleable.custom_attrs,defStyle,R.style.default_style
        );
        // 获得属性值,这个api不是很直观,里面使用的生成的styleable而不是直接给定attr去获取
        int custom1_color=a.getColor(R.styleable.custom_attrs_custom_color1,0);
        Log.d(TAG,Integer.toHexString(custom1_color));

        int custom2_color=a.getColor(R.styleable.custom_attrs_custom_color2,0);
        Log.d(TAG,Integer.toHexString(custom2_color));

        int custom3_color=a.getColor(R.styleable.custom_attrs_custom_color3,0);
        Log.d(TAG,Integer.toHexString(custom3_color));

        int custom4_color=a.getColor(R.styleable.custom_attrs_custom_color4,0);
        Log.d(TAG,Integer.toHexString(custom4_color));

        int custom5_color=a.getColor(R.styleable.custom_attrs_custom_color5,0);
        Log.d(TAG,Integer.toHexString(custom5_color));

        /**
         * custom1~5的属性分别为:ff000000,ff111111,ff222222,0,0
         * 可见,再有相同属性的情况下,直接写在xml中的优先级最高,其次是在xml中的style指定的,再其次是theme中通过attr引用的style指定的,再再其次是theme中直接指定的
         * 注意到再default_style中的4和5没有生效,因为defStyleAttr不为0
         * 有的blog说如果给定了defStyle但是theme中没有指定也要去default_style获取,但是实际测试发现并没有,而是直接是默认值
         */




    }
}
