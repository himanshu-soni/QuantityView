# QuantityView
Android quantity view with add and remove button to simply use as a complex widget with handful of quick customizations.

[ ![Download](https://api.bintray.com/packages/himanshu-soni/maven/quantity-view/images/download.svg) ](https://bintray.com/himanshu-soni/maven/quantity-view/_latestVersion)

### Sample Screen
![QuantityView](https://raw.githubusercontent.com/himanshu-soni/QuantityView/master/screenshots/device-2015-09-29-191352.png)

### Installation
add gradle dependency to your dependency listupdaupdateu:

``` groovy
dependencies {
	compile 'me.himanshusoni.quantityview:quantity-view:1.0.0'
}
```

### Use
1. Include `QuantityView` in your xml.

``` xml
<me.himanshusoni.quantityview.QuantityView
	xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/quantityView_default"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_marginTop="10dp"
    app:qv_quantity="10" />
```


### Customization
Attributes:

``` xml
app:qv_addButtonBackground="color|drawable"
app:qv_addButtonText="string"
app:qv_addButtonTextColor="color"
app:qv_removeButtonBackground="color|drawable"
app:qv_removeButtonText="string"
app:qv_removeButtonTextColor="color"
app:qv_quantityBackground="color|drawable"
app:qv_quantityTextColor="color"
app:qv_quantity="integer"
app:qv_quantityPadding="dimension"
app:qv_maxQuantity="integer"
app:qv_minQuantity="integer"
```

==================
developed to make programming easy.

by Himanshu Soni (himanshusoni.me@gmail.com)

