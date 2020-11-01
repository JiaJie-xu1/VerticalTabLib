# VerticalTabLib
仿京东列表侧边栏UI，Androidx
UI需求，仿京东分类侧边栏，在github上找到一个开源项目[VerticalTabLayout](https://github.com/qstumn/VerticalTabLayout)。**感谢开源**! 但是这个项目已经很久没有维护了（不支持AndroidX,使用Kotlin AS无法编译，且tab页的切换过于粗暴，不满足UI设计师的需求）在此框架的基础上，开发了一套新的侧边栏框架，并贡献出来，希望可以帮助到大家

博客地址：https://blog.csdn.net/Json_Jerry/article/details/109371567

### 效果图
![image](https://github.com/JiaJie-xu1/VerticalTabLib/blob/master/demo1.gif)
![image](https://github.com/JiaJie-xu1/VerticalTabLib/blob/master/demo2.gif)


#### How To Use

Step 1. Add the JitPack repository to your build file


```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

```

Step 2. Add the dependency


```
dependencies {
	        implementation 'com.github.JiaJie-xu1:VerticalTabLib:2.0.1'
	}
```

Step 3. xml

```
<com.partner.tabtools.verticalTab.VerticalTabLayout
                android:id="@+id/verticalTabLayout"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:background="#f7f7f7"
                app:indicator_color="#64e4f2"
                app:indicator_gravity="left"
                app:tab_mode="scrollable"
                app:tab_height="@dimen/dp55"/>
```
Step 4. adapter方法创建(kotlin写法)

```
adapter =object : TabAdapter {
            override fun getIcon(position: Int): TabView.TabIcon? {
                return null
            }

            override fun getBadge(position: Int): TabView.TabBadge? {
                return null
            }

            override fun getBackground(position: Int): Int {
                return resources.getColor(R.color.white)
            }

            override fun getTitle(position: Int): TabView.TabTitle {
                return TabView.TabTitle.Builder()
                    .setContent(tabsTitle[position])
                    .setTextSize(DisplayUtil.getSR(13))
                    .setTextColor(0xFFcbcbcc.toInt(), 0xFF4a4a4a.toInt())
                    .build()
            }

            override fun getCount(): Int {
                return tabsTitle.size
            }

        }
        verticalTabLayout.setTabAdapter(adapter)
```
java写法

```
tablayout.setTabAdapter(new TabAdapter() {
            @Override
            public int getCount() {
                return 0;
            }

            @Override
            public TabView.TabBadge getBadge(int position) {
                return null;
            }

            @Override
            public TabView.TabIcon getIcon(int position) {
                return null;
            }

            @Override
            public TabView.TabTitle getTitle(int position) {
                return null;
            }

            @Override
            public int getBackground(int position) {
                return 0;
            }
	     });
```

```
按照自己的需要进行返回相应的值即可，不需要的返回0或者null
TabBadge、TabIcon、TabTitle使用build模式创建。
```

属性说明

xml | code | 说明
---|---|---
app:indicator_color | setIndicatorColor | 指示器颜色
app:indicator_width | setIndicatorWidth | 指示器宽度
app:indicator_gravity | setIndicatorGravity | 指示器位置
app:indicator_corners | setIndicatorCorners | 指示器圆角
app:tab_mode | setTabMode | Tab高度模式
app:tab_height | setTabHeight | Tab高度
app:tab_margin | setTabMargin | Tab间距
