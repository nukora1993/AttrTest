# AttrTest
Android属性读取测试，总结一下属性的用法

attr:规定了属性的name和格式

item：赋值的attr

styleable：attr的集合

style：item的集合



## public final TypedArray obtainStyledAttributes(AttributeSet set,int[] attrs,int defStyleAttr,int defStyleRes)
              
set:通过xml直接定义的属性或者通过定义style间接的属性

attrs:要获取的那些attr的id，是一个数组，传入R.styleable或者int[]{attr1,attr2...}

defStyleAttr:当前theme中通过一个reference引用的style就是defStyleAttr，注意这个是一个id，需要指定该id

defStyleRes:当defStyleAttr为0时，或者theme中不存在第三个参数指定的style时，可以通过指定该style id作为默认的属性值

## 其他几个方法重载

1.public final TypedArray obtainStyledAttributes(
             AttributeSet set, int[] attrs) {
          return getTheme().obtainStyledAttributes(set, attrs, 0, 0);
      }

只在xml指定的属性中查找

2.public final TypedArray obtainStyledAttributes(int[] attrs) {
            return getTheme().obtainStyledAttributes(attrs);
        }

只在theme中获取属性

3.public final TypedArray obtainStyledAttributes(int resid,
                int[] attrs) throws Resources.NotFoundException {
            return getTheme().obtainStyledAttributes(resid, attrs);
        }

只在指定style获取属性

优先级：如果同一个attr的值在多个地方均有定义，
那么xml直接指定>xml的style指定>主题style指定>主题直接指定>defRes



