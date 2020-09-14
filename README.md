# VerticalTabLib
仿京东列表侧边栏UI，Androidx
UI需求，仿京东分类侧边栏，在github上找到一个开源项目[VerticalTabLayout](https://github.com/qstumn/VerticalTabLayout)。**感谢开源**! 但是这个项目已经很久没有维护了，且tab页的切换过于粗暴，不满足UI设计师的需求，在此框架的基础上，我开发了一套新的侧边栏框架，并贡献出来，希望可以帮助到大家

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
