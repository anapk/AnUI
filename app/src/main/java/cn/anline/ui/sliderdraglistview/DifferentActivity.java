package cn.anline.ui.sliderdraglistview;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import cn.anline.ui.sliderdraglistview.QQ;
import cn.anline.ui.yydcdut.sdlv.Menu;
import cn.anline.ui.yydcdut.sdlv.MenuItem;
import cn.anline.ui.yydcdut.sdlv.SlideAndDragListView;

import java.util.ArrayList;
import java.util.List;

import cn.anline.ui.R;

/**
 * Created by yuyidong on 16/1/23.
 */
public class DifferentActivity extends AppCompatActivity implements SlideAndDragListView.OnListItemLongClickListener,
        SlideAndDragListView.OnDragListener, SlideAndDragListView.OnSlideListener,
        SlideAndDragListView.OnListItemClickListener, SlideAndDragListView.OnMenuItemClickListener,
        SlideAndDragListView.OnItemDeleteListener {
    private static final String TAG = DifferentActivity.class.getSimpleName();

    private List<Menu> mMenuList;
    private List<QQ> mQQList;
    private SlideAndDragListView<QQ> mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdlv);
        initData();
        initMenu();
        initUiAndListener();
    }

    public void initData() {
        mQQList = new ArrayList<>();
        mQQList.add(new QQ("Sober", "跨年抢Tutu红包", "12:30", R.drawable.q1));
        mQQList.add(new QQ("哑舍;", "嘟嘟也�?�渐走向演艺�?.", "12:30", R.drawable.q2));
        mQQList.add(new QQ("Funnythan", "哑舍;:Sing For You.", "12:30", R.drawable.q3, true, 12));
        mQQList.add(new QQ("白日梦想�?", "颜�?�界扛把子：濒危物种少女.", "12:30", R.drawable.q4, true, 22));
        mQQList.add(new QQ("颜�?�界扛把�?", "谁觉得自己本人比照片好看", "12:30", R.drawable.q5));
        mQQList.add(new QQ("SEHUN.", "朴灿烈撩妹高�?", "12:30", R.drawable.q6));
        mQQList.add(new QQ("MADE.", "他叫张毅我叫黄盼祝我们久", "12:30", R.drawable.q7));
        mQQList.add(new QQ("王�?�艺兴！", "少女肩带：[图片]", "12:30", R.drawable.q8, true, 12));
        mQQList.add(new QQ("理山", "不是浪不够只是爱自由", "12:30", R.drawable.q9));
        mQQList.add(new QQ("少女肩带", "BIGBANG", "12:30", R.drawable.q10));
        mQQList.add(new QQ("小傲�?.", "�?后的问�??", "12:30", R.drawable.q11));
        mQQList.add(new QQ("跟着艺兴有糖�?", "听说男神和女神正在找网名", "12:30", R.drawable.q12));
        mQQList.add(new QQ("神枪手萝�?", "夺走你初吻的人现在他牵了别人的手,姑娘我想认识�?.", "12:30", R.drawable.q13));
        mQQList.add(new QQ("过往不究", "今年的寒潮估计是受了南山南的诅咒了吧", "12:30", R.drawable.q14));
        mQQList.add(new QQ("持烟美痞", "破百才去告白你到底爱不爱", "12:30", R.drawable.q15, true, 12));
        mQQList.add(new QQ("他不缺我�?", "我想在这里处个女闺蜜 真心的啊�?", "12:30", R.drawable.q16));
        mQQList.add(new QQ("Monster.", "别把自己弄得太狼狈毕竟没有人会替你解围�??", "12:30", R.drawable.q17));
        mQQList.add(new QQ("南方姑娘.", "小时候的石头剪刀布�?�是要跺�?下脚才有气势", "12:30", R.drawable.q18));
        mQQList.add(new QQ("少女贩卖�?", "南方姑娘：疏远不�?定是讨厌也许是太喜欢", "12:30", R.drawable.q19, true, 12));
        mQQList.add(new QQ("人甜脾气�?", "“喜欢就争取 得到就珍�? 错过就忘记�??", "12:30", R.drawable.q20));
        mQQList.add(new QQ("鸨姒", "我父亲是这个世界上最帅的嗯至少我是这么觉得的", "12:30", R.drawable.q21));
        mQQList.add(new QQ("南风知我�?.", "在所有人事已非的景色里我�?喜欢�?", "12:30", R.drawable.q22));
        mQQList.add(new QQ("路还长天会亮", "�?谓放假，家里遭嫌，出门没钱，每天特闲", "12:30", R.drawable.q23));
        mQQList.add(new QQ("菰芏�?", "广西第一场雪.", "12:30", R.drawable.q24));
        mQQList.add(new QQ("挽贤.", "路还长天会亮：[图片]", "12:30", R.drawable.q25, true, 12));
        mQQList.add(new QQ("堕落�?", "“可能因为我近视，有些人走近了才看清。�??", "12:30", R.drawable.q26));
        mQQList.add(new QQ("平胸只是为了离你更近", "神枪手萝莉：[图片]", "12:30", R.drawable.q27, true, 12));
        mQQList.add(new QQ("蛊坏", "九九年生于南方喜于北方烈酒故事愿识你", "12:30", R.drawable.q28));
        mQQList.add(new QQ("四年了我还爱�?", "刚分手的女孩过来吧，我心疼你�?", "12:30", R.drawable.q29));
        mQQList.add(new QQ("眉间心上", "蛊坏：我喜欢�?无所有的感觉 它让我干�?得像�?个死去多年的�?", "12:30", R.drawable.q30, true, 12));
        mQQList.add(new QQ("次元少女.", "我讨厌腾讯来个特别关心的功能 却又不显示是谁特别关心着�?", "12:30", R.drawable.q31));
        mQQList.add(new QQ("清悸", "我把思念熬成黑眼圈等你一句晚�?", "12:30", R.drawable.q32));
        mQQList.add(new QQ("孤独患�??.", "见面少没关系 你别喜欢上别人就�?.", "12:30", R.drawable.q33));
        mQQList.add(new QQ("仙女味的�?", "你是不是也觉得自己多余才会先离开�?", "12:30", R.drawable.q34));
        mQQList.add(new QQ("北三�?.", "到后来你会不会想到有�?个人也喜欢了你好几年", "12:30", R.drawable.q35));
        mQQList.add(new QQ("白日梦想�?", "据说女生迟早会喜欢上那个�?直陪他聊天的男生", "12:30", R.drawable.q36));
        mQQList.add(new QQ("粒尼", "�?谓成熟就是明明该哭该闹却不言不语的微�?", "12:30", R.drawable.q37));
    }

    public void initMenu() {
        mMenuList = new ArrayList<>(2);
        Menu menu0 = new Menu(new ColorDrawable(Color.WHITE), true, 0);
        menu0.addItem(new MenuItem.Builder().setWidth((int) getResources().getDimension(R.dimen.slv_item_bg_btn2_width))
                .setBackground(new ColorDrawable(Color.RED))
                .setText("删除")
                .setDirection(MenuItem.DIRECTION_RIGHT)
                .setTextColor(Color.WHITE)
                .setTextSize((int) getResources().getDimension(R.dimen.txt_qq))
                .build());
        menu0.addItem(new MenuItem.Builder().setWidth((int) getResources().getDimension(R.dimen.slv_item_bg_btn_width_img))
                .setBackground(new ColorDrawable(Color.GREEN))
                .setText("标为未读")
                .setDirection(MenuItem.DIRECTION_RIGHT)
                .setTextColor(Color.WHITE)
                .setTextSize((int) getResources().getDimension(R.dimen.txt_qq))
                .build());
        menu0.addItem(new MenuItem.Builder().setWidth((int) getResources().getDimension(R.dimen.slv_item_bg_btn2_width))
                .setBackground(new ColorDrawable(Color.GRAY))
                .setText("置顶")
                .setDirection(MenuItem.DIRECTION_RIGHT)
                .setTextColor(Color.WHITE)
                .setTextSize((int) getResources().getDimension(R.dimen.txt_qq))
                .build());
        menu0.addItem(new MenuItem.Builder().setWidth((int) getResources().getDimension(R.dimen.slv_item_bg_btn_width_img))
                .setBackground(new ColorDrawable(Color.BLACK))
                .setDirection(MenuItem.DIRECTION_LEFT)
                .setIcon(getResources().getDrawable(R.drawable.ic_launcher))
                .build());
        Menu menu1 = new Menu(new ColorDrawable(Color.WHITE), false, 1);
        menu1.addItem(new MenuItem.Builder().setWidth((int) getResources().getDimension(R.dimen.slv_item_bg_btn2_width))
                .setBackground(new ColorDrawable(Color.RED))
                .setText("删除")
                .setDirection(MenuItem.DIRECTION_RIGHT)
                .setTextColor(Color.WHITE)
                .setTextSize((int) getResources().getDimension(R.dimen.txt_qq))
                .build());
        menu1.addItem(new MenuItem.Builder().setWidth((int) getResources().getDimension(R.dimen.slv_item_bg_btn2_width))
                .setBackground(new ColorDrawable(Color.GRAY))
                .setText("置顶")
                .setDirection(MenuItem.DIRECTION_RIGHT)
                .setTextColor(Color.WHITE)
                .setTextSize((int) getResources().getDimension(R.dimen.txt_qq))
                .build());
        menu1.addItem(new MenuItem.Builder().setWidth((int) getResources().getDimension(R.dimen.slv_item_bg_btn2_width))
                .setBackground(new ColorDrawable(Color.BLUE))
                .setText("QQ�?")
                .setTextColor(Color.WHITE)
                .setTextSize((int) getResources().getDimension(R.dimen.txt_qq))
                .build());
        menu1.addItem(new MenuItem.Builder().setWidth((int) getResources().getDimension(R.dimen.slv_item_bg_btn_width_img))
                .setBackground(new ColorDrawable(Color.BLACK))
                .setDirection(MenuItem.DIRECTION_LEFT)
                .setIcon(getResources().getDrawable(R.drawable.ic_launcher))
                .build());
        mMenuList.add(menu0);
        mMenuList.add(menu1);
    }

    public void initUiAndListener() {
        mListView = (SlideAndDragListView) findViewById(R.id.lv_edit);
        mListView.setMenu(mMenuList);
        mListView.setAdapter(mAdapter);
        mListView.setOnListItemLongClickListener(this);
        mListView.setOnDragListener(this, mQQList);
        mListView.setOnListItemClickListener(this);
        mListView.setOnSlideListener(this);
        mListView.setOnMenuItemClickListener(this);
        mListView.setOnItemDeleteListener(this);
        mListView.setDivider(new ColorDrawable(Color.GRAY));
        mListView.setDividerHeight(1);
    }

    private BaseAdapter mAdapter = new BaseAdapter() {
        @Override
        public int getCount() {
            return mQQList.size();
        }

        @Override
        public Object getItem(int position) {
            return mQQList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public int getItemViewType(int position) {
            if (mQQList.get(position).isQun()) {
                return 1;
            } else {
                return 0;
            }
        }

        @Override
        public int getViewTypeCount() {
            return 2;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            CustomViewHolder cvh = null;
            if (convertView == null) {
                cvh = new CustomViewHolder();
                convertView = LayoutInflater.from(DifferentActivity.this).inflate(R.layout.item_qq, null);
                cvh.imgLogo = (ImageView) convertView.findViewById(R.id.img_item_qq);
                cvh.txtName = (TextView) convertView.findViewById(R.id.txt_item_qq_title);
                cvh.txtContent = (TextView) convertView.findViewById(R.id.txt_item_qq_content);
                convertView.setTag(cvh);
            } else {
                cvh = (CustomViewHolder) convertView.getTag();
            }
            QQ item = (QQ) this.getItem(position);
            cvh.imgLogo.setImageResource(item.getDrawableRes());
            cvh.txtContent.setText(item.getContent());
            if (getItemViewType(position) == 0) {
                cvh.txtName.setText(item.getName());
            } else {
                cvh.txtName.setText("(QQ�?) " + item.getName() + "(" + item.getQunNumber() + ")");
            }
            return convertView;
        }

        class CustomViewHolder {
            public ImageView imgLogo;
            public TextView txtName;
            public TextView txtContent;
        }

    };

    @Override
    public void onListItemLongClick(View view, int position) {
        Toast.makeText(DifferentActivity.this, "onItemLongClick   position--->" + position, Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onListItemLongClick   " + position);
    }

    @Override
    public void onDragViewStart(int position) {
        Toast.makeText(DifferentActivity.this, "onDragViewStart   position--->" + position, Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onDragViewStart   " + position);
    }

    @Override
    public void onDragViewMoving(int position) {
//        Toast.makeText(DifferentActivity.this, "onDragViewMoving   position--->" + position, Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onDragViewMoving   " + position);
    }

    @Override
    public void onDragViewDown(int position) {
        Toast.makeText(DifferentActivity.this, "onDragViewDown   position--->" + position, Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onDragViewDown   " + position);
    }

    @Override
    public void onListItemClick(View v, int position) {
        Toast.makeText(DifferentActivity.this, "onItemClick   position--->" + position, Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onListItemClick   " + position);
    }

    @Override
    public void onSlideOpen(View view, View parentView, int position, int direction) {
        Toast.makeText(DifferentActivity.this, "onSlideOpen   position--->" + position + "  direction--->" + direction, Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onSlideOpen   " + position);
    }

    @Override
    public void onSlideClose(View view, View parentView, int position, int direction) {
        Toast.makeText(DifferentActivity.this, "onSlideClose   position--->" + position + "  direction--->" + direction, Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onSlideClose   " + position);
    }

    @Override
    public int onMenuItemClick(View v, int itemPosition, int buttonPosition, int direction) {
        Log.i(TAG, "onMenuItemClick   " + itemPosition + "   " + buttonPosition + "   " + direction);
        int viewType = mAdapter.getItemViewType(itemPosition);
        switch (viewType) {
            case 0:
                return clickMenuBtn0(buttonPosition, direction);
            case 1:
                return clickMenuBtn1(buttonPosition, direction);
            default:
                return Menu.ITEM_NOTHING;
        }
    }

    private int clickMenuBtn0(int buttonPosition, int direction) {
        switch (direction) {
            case MenuItem.DIRECTION_LEFT:
                switch (buttonPosition) {
                    case 0:
                        return Menu.ITEM_SCROLL_BACK;
                }
                break;
            case MenuItem.DIRECTION_RIGHT:
                switch (buttonPosition) {
                    case 0:
                        return Menu.ITEM_DELETE_FROM_BOTTOM_TO_TOP;
                    case 1:
                        return Menu.ITEM_NOTHING;
                    case 2:
                        return Menu.ITEM_SCROLL_BACK;
                }
        }
        return Menu.ITEM_NOTHING;
    }

    private int clickMenuBtn1(int buttonPosition, int direction) {
        switch (direction) {
            case MenuItem.DIRECTION_LEFT:
                switch (buttonPosition) {
                    case 0:
                        return Menu.ITEM_SCROLL_BACK;
                }
                break;
            case MenuItem.DIRECTION_RIGHT:
                switch (buttonPosition) {
                    case 0:
                        return Menu.ITEM_DELETE_FROM_BOTTOM_TO_TOP;
                    case 1:
                        return Menu.ITEM_SCROLL_BACK;
                }
        }
        return Menu.ITEM_NOTHING;
    }

    @Override
    public void onItemDelete(View view, int position) {
        mQQList.remove(position - mListView.getHeaderViewsCount());
        mAdapter.notifyDataSetChanged();
    }
}
