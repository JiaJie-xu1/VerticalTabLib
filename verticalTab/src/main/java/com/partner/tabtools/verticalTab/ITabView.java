package com.partner.tabtools.verticalTab;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.View;


/**
 * @author JayXu
 */

public interface ITabView {

    ITabView setBadge(TabView.TabBadge badge);

    ITabView setIcon(TabView.TabIcon icon);

    ITabView setTitle(TabView.TabTitle title);

    ITabView setBackground(int resid);

    TabView.TabBadge getBadge();

    TabView.TabIcon getIcon();

    TabView.TabTitle getTitle();

    View getTabView();

}
