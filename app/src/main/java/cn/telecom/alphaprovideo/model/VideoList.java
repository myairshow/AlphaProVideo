package cn.telecom.alphaprovideo.model;

import android.util.SparseArray;

import com.google.gson.Gson;

import java.util.ArrayList;

public class VideoList {

    private static volatile VideoList instance;

    public static VideoList getInstance() {
        if (null == instance) {
            synchronized (VideoList.class) {
                if (null == instance)
                    instance = new Gson().fromJson(json, VideoList.class);
            }
        }
        return instance;
    }

    private final static String json = "{\n" +
            "    \"items\": [\n" +
            "        {\n" +
            "            \"author\": \"Conan\",\n" +
            "            \"cover\": \"http://img-wscdn.icartoons.cn/group6/M00/68/B1/wKgbWVkbuLiASQkKAAAcdIMPx3U602.jpg?flow_flag=70721837&flow_type=1&flow_channel=api&dm_sid=15348521932327543057e73ad913f645&trackid=15348521932327543057e73ad913f645----&client_style=1\",\n" +
            "            \"description\": \"【UP 主：Conan 】【来源于YTB ：https://www.youtube.com/watch?v=kFaoBOiQkBA 】【预告】拳皇97OL 超燃动画投递稿，如侵删。\",\n" +
            "            \"id\": \"2S201705122200097871\",\n" +
            "            \"picture\": \"http://img-wscdn.icartoons.cn/group5/M00/02/82/wKgbTlkcKNCAZGbQAABvvcyXHes751.jpg?flow_flag=70721837&flow_type=1&flow_channel=api&dm_sid=15348521932327543057e73ad913f645&trackid=15348521932327543057e73ad913f645----&client_style=1\",\n" +
            "            \"title\": \"【预告】拳皇97OL超燃动画\",\n" +
            "            \"url\": \"http://streaming-hls.icartoons.cn:7485/group2/M00/F4/DB/wKgbWFkgKCKAJ8rqAAABuW-QPpo95.m3u8\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"author\": \"Conan\",\n" +
            "            \"cover\": \"http://img-wscdn.icartoons.cn/group5/M00/68/E2/wKgbXlkbuK-AFFYVAAAr9VMyI0Y682.jpg?flow_flag=70721837&flow_type=1&flow_channel=api&dm_sid=15348521932327543057e73ad913f645&trackid=15348521932327543057e73ad913f645----&client_style=1\",\n" +
            "            \"description\": \"【UP 主：Conan 】【来源于YTB ：https://www.youtube.com/watch?v=Dx6NWaBbJOE 】【预告】拳皇动画《命运》PV 宣传片投递稿，如侵删。\",\n" +
            "            \"id\": \"2S201705102200097803\",\n" +
            "            \"picture\": \"http://img-wscdn.icartoons.cn/group7/M00/02/54/wKgbTVkbuGCAUH4sAACkKqiJ-yk550.jpg?flow_flag=70721837&flow_type=1&flow_channel=api&dm_sid=15348521932327543057e73ad913f645&trackid=15348521932327543057e73ad913f645----&client_style=1\",\n" +
            "            \"title\": \"【预告】拳皇动画《命运》PV宣传片\",\n" +
            "            \"url\": \"http://streaming-hls.icartoons.cn:7485/group1/M00/EE/EF/wKgbWlkdXNuAO7uzAAABuYyeHFY82.m3u8\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"author\": \"MILU\",\n" +
            "            \"cover\": \"http://img-wscdn.icartoons.cn/group7/M00/02/54/wKgbTVkbuHuAIxxOAAAR3UAQnDI839.jpg?flow_flag=70721837&flow_type=1&flow_channel=api&dm_sid=15348521932327543057e73ad913f645&trackid=15348521932327543057e73ad913f645----&client_style=1\",\n" +
            "            \"description\": \"【UP 主：miluuuu 】【来源于YTB ：https://www.youtube.com/watch?v=rxUox5wDjpY 】【预告】【异形：圣约】全新预告。投递稿，如侵删。\",\n" +
            "            \"id\": \"2S201705122200097894\",\n" +
            "            \"picture\": \"http://img-wscdn.icartoons.cn/group6/M00/02/52/wKgbVVkcKaaAHM4bAABoVyq6Aro275.jpg?flow_flag=70721837&flow_type=1&flow_channel=api&dm_sid=15348521932327543057e73ad913f645&trackid=15348521932327543057e73ad913f645----&client_style=1\",\n" +
            "            \"title\": \"【预告】【异形：圣约】全新预告\",\n" +
            "            \"url\": \"http://streaming-hls.icartoons.cn:7485/group1/M00/EE/EF/wKgbWlkdXOKAeFdVAAABuddL4q090.m3u8\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"author\": \"MILU\",\n" +
            "            \"cover\": \"http://img-wscdn.icartoons.cn/group7/M00/02/0E/wKgbTVj51VCAdldRAAAwCFpUmQI343.jpg?flow_flag=70721837&flow_type=1&flow_channel=api&dm_sid=15348521932327543057e73ad913f645&trackid=15348521932327543057e73ad913f645----&client_style=1\",\n" +
            "            \"description\": \"【UP 主：miluuuu 】投递稿，如侵删。\",\n" +
            "            \"id\": \"2S201704182200097519\",\n" +
            "            \"picture\": \"http://img-wscdn.icartoons.cn/group6/M00/68/6C/wKgbWVj51YmALJtvAACQx8w7muw563.jpg?flow_flag=70721837&flow_type=1&flow_channel=api&dm_sid=15348521932327543057e73ad913f645&trackid=15348521932327543057e73ad913f645----&client_style=1\",\n" +
            "            \"title\": \"【预告】剧场版「黑子的篮球」LAST GAME PV \",\n" +
            "            \"url\": \"http://streaming-hls.icartoons.cn:7485/group2/M00/F0/2C/wKgbWFj9sHmAS17EAAABuYzJ2Jg47.m3u8\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"author\": \"糖心\",\n" +
            "            \"cover\": \"http://img-wscdn.icartoons.cn/group7/M00/68/67/wKgbW1j4XMKAVqlaAABOcAjY1Kw672.jpg?flow_flag=70721837&flow_type=1&flow_channel=api&dm_sid=15348521932327543057e73ad913f645&trackid=15348521932327543057e73ad913f645----&client_style=1\",\n" +
            "            \"description\": \"【UP 主：糖心】 【预告】太乙仙魔录之灵飞纪 第二季 终极预告片! 。投递稿，如侵删。\",\n" +
            "            \"id\": \"2S201704182200097524\",\n" +
            "            \"picture\": \"http://img-wscdn.icartoons.cn/group6/M00/68/67/wKgbWVj4XMKAabyRAAFYJQNAZSU746.jpg?flow_flag=70721837&flow_type=1&flow_channel=api&dm_sid=15348521932327543057e73ad913f645&trackid=15348521932327543057e73ad913f645----&client_style=1\",\n" +
            "            \"title\": \" 【预告】太乙仙魔录之灵飞纪 第二季 终极预告片\",\n" +
            "            \"url\": \"http://streaming-hls.icartoons.cn:7485/group1/M00/0D/63/wKgbYFj5ylmAAxymAAABuUi37Uk21.m3u8\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"author\": \"蓝弦\",\n" +
            "            \"cover\": \"http://img-wscdn.icartoons.cn/group7/M00/01/FA/wKgbTVjvPoiAGz8XAABB-fWYs3w264.jpg?flow_flag=70721837&flow_type=1&flow_channel=api&dm_sid=15348521932327543057e73ad913f645&trackid=15348521932327543057e73ad913f645----&client_style=1\",\n" +
            "            \"description\": \"【UP 主：蓝弦】【来源于YTB ：https://www.youtube.com/watch?v=mfD-Wk8Gwbc 】【预告】斉木楠雄的灾难 电影人物与原著对比。投递稿，如侵删。\",\n" +
            "            \"id\": \"2S201704122200097379\",\n" +
            "            \"picture\": \"http://img-wscdn.icartoons.cn/group6/M00/68/58/wKgbWVjvPrmAOnFJAAChaJQMEz8505.jpg?flow_flag=70721837&flow_type=1&flow_channel=api&dm_sid=15348521932327543057e73ad913f645&trackid=15348521932327543057e73ad913f645----&client_style=1\",\n" +
            "            \"title\": \"【预告】斉木楠雄的灾难 电影人物与原著对比\",\n" +
            "            \"url\": \"http://streaming-hls.icartoons.cn:7485/group1/M00/E8/A8/wKgbWlj0lMiAU1kjAAABLZJy3rs79.m3u8\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"author\": \"蓝弦\",\n" +
            "            \"cover\": \"http://img-wscdn.icartoons.cn/group6/M00/68/58/wKgbWVjvPsqAPDGnAAAqmF9oRX0470.jpg?flow_flag=70721837&flow_type=1&flow_channel=api&dm_sid=15348521932327543057e73ad913f645&trackid=15348521932327543057e73ad913f645----&client_style=1\",\n" +
            "            \"description\": \"【UP 主：蓝弦】【来源于YTB ：https://www.youtube.com/watch?v=hVQaR8mo6ew 】【预告】《钢之炼金术师》真人版 最新预告Pv 第一弹 将于2017 年冬天上映! 。投递稿，如侵删。\",\n" +
            "            \"id\": \"2S201704122200097380\",\n" +
            "            \"picture\": \"http://img-wscdn.icartoons.cn/group5/M00/68/5E/wKgbXljvPsqABmA4AACSpN942y0010.jpg?flow_flag=70721837&flow_type=1&flow_channel=api&dm_sid=15348521932327543057e73ad913f645&trackid=15348521932327543057e73ad913f645----&client_style=1\",\n" +
            "            \"title\": \"【预告】《钢之炼金术师》真人版 最新预告Pv\",\n" +
            "            \"url\": \"http://streaming-hls.icartoons.cn:7485/group2/M00/EE/62/wKgbWFj0kyKAPDcIAAABuVc7TTU54.m3u8\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"author\": \"蓝弦\",\n" +
            "            \"cover\": \"http://img-wscdn.icartoons.cn/group5/M00/68/5E/wKgbXljvPqmAUr8vAAA_Cx-MOR0226.jpg?flow_flag=70721837&flow_type=1&flow_channel=api&dm_sid=15348521932327543057e73ad913f645&trackid=15348521932327543057e73ad913f645----&client_style=1\",\n" +
            "            \"description\": \"【UP 主：蓝弦】【来源于YTB ：https://www.youtube.com/watch?v=fKgV0ydd0BY 】【预告】银魂 电影人物与原著对比。投递稿，如侵删。\",\n" +
            "            \"id\": \"2S201704122200097378\",\n" +
            "            \"picture\": \"http://img-wscdn.icartoons.cn/group7/M00/01/FA/wKgbTVjvPneACUUsAACe0GfuaIM401.jpg?flow_flag=70721837&flow_type=1&flow_channel=api&dm_sid=15348521932327543057e73ad913f645&trackid=15348521932327543057e73ad913f645----&client_style=1\",\n" +
            "            \"title\": \"【预告】银魂 电影人物与原著对比\",\n" +
            "            \"url\": \"http://streaming-hls.icartoons.cn:7485/group1/M00/E8/8E/wKgbWlj0hVCAEH3SAAABLXPSi3o92.m3u8\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"author\": \"蓝弦\",\n" +
            "            \"cover\": \"http://img-wscdn.icartoons.cn/group5/M00/01/FD/wKgbTljvruqAc0bGAAArVGXJDtY546.jpg?flow_flag=70721837&flow_type=1&flow_channel=api&dm_sid=15348521932327543057e73ad913f645&trackid=15348521932327543057e73ad913f645----&client_style=1\",\n" +
            "            \"description\": \"【UP 主：蓝弦】【来源于YTB ：https://www.youtube.com/watch?v=-Et2TL4UoBs 】【预告】『银魂』2017 年正月问候歌+ 真人电影版预告（三人说想成为海贼王）。投递稿，如侵删。\",\n" +
            "            \"id\": \"2S201704122200097382\",\n" +
            "            \"picture\": \"http://img-wscdn.icartoons.cn/group7/M00/68/58/wKgbW1jvPsCAIIrgAACe1eRjKXI321.jpg?flow_flag=70721837&flow_type=1&flow_channel=api&dm_sid=15348521932327543057e73ad913f645&trackid=15348521932327543057e73ad913f645----&client_style=1\",\n" +
            "            \"title\": \"【预告】『银魂』2017年正月问候歌+真人电影版预告\",\n" +
            "            \"url\": \"http://streaming-hls.icartoons.cn:7485/group2/M00/EE/4D/wKgbWFj0g8iAVl7jAAABufiNYro91.m3u8\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"author\": \"MILU\",\n" +
            "            \"cover\": \"http://img-wscdn.icartoons.cn/group6/M00/01/DC/wKgbVVjc8emAQGZwAAAp3sMa5F4596.jpg?flow_flag=70721837&flow_type=1&flow_channel=api&dm_sid=15348521932327543057e73ad913f645&trackid=15348521932327543057e73ad913f645----&client_style=1\",\n" +
            "            \"description\": \"【UP 主：miluuuu 】【来源于YTB ：https://www.youtube.com/watch?v=kkBdOiaDmRc 】【【你的名字】【预告第2 弹】 】投递稿，如侵删。\",\n" +
            "            \"id\": \"2S201703242200097090\",\n" +
            "            \"picture\": \"http://img-wscdn.icartoons.cn/group5/M00/68/33/wKgbXljYiD2AVYLBAACjyjiZ8kE684.jpg?flow_flag=70721837&flow_type=1&flow_channel=api&dm_sid=15348521932327543057e73ad913f645&trackid=15348521932327543057e73ad913f645----&client_style=1\",\n" +
            "            \"title\": \"【你的名字】【预告第2弹】！全一集\",\n" +
            "            \"url\": \"http://streaming-hls.icartoons.cn:7485/group1/M00/E5/BF/wKgbWljcypWAXkvVAAABubktb6I98.m3u8\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"author\": \"MILU\",\n" +
            "            \"cover\": \"http://img-wscdn.icartoons.cn/group6/M00/01/DC/wKgbVVjc8emAQGZwAAAp3sMa5F4596.jpg?flow_flag=70721837&flow_type=1&flow_channel=api&dm_sid=15348521932327543057e73ad913f645&trackid=15348521932327543057e73ad913f645----&client_style=1\",\n" +
            "            \"description\": \"【UP 主：miluuuu 】【来源于YTB ：https://www.youtube.com/watch?v=kkBdOiaDmRc 】【【你的名字】【预告第2 弹】 】投递稿，如侵删。\",\n" +
            "            \"id\": \"2S201703242200097090\",\n" +
            "            \"picture\": \"http://img-wscdn.icartoons.cn/group5/M00/68/33/wKgbXljYiD2AVYLBAACjyjiZ8kE684.jpg?flow_flag=70721837&flow_type=1&flow_channel=api&dm_sid=15348521932327543057e73ad913f645&trackid=15348521932327543057e73ad913f645----&client_style=1\",\n" +
            "            \"title\": \"【你的名字】【预告第2弹】！全一集\",\n" +
            "            \"url\": \"http://streaming-hls.icartoons.cn:7485/group1/M00/E5/BF/wKgbWljcypWAXkvVAAABubktb6I98.m3u8\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"author\": \"蓝弦\",\n" +
            "            \"cover\": \"http://img-wscdn.icartoons.cn/group5/M00/67/B2/wKgbXljKB_CARS-pAABTbIITtHw484.jpg?flow_flag=70721837&flow_type=1&flow_channel=api&dm_sid=15348521932327543057e73ad913f645&trackid=15348521932327543057e73ad913f645----&client_style=1\",\n" +
            "            \"description\": \"【UP 主：蓝弦】【来源于YTB ：https://www.youtube.com/watch?v=CCLZojjD6wc 】【刀剑神域序列争战】【最终加长版中文电影预告】投递稿，如侵删。\",\n" +
            "            \"id\": \"2S201703142200096962\",\n" +
            "            \"picture\": \"http://img-wscdn.icartoons.cn/group6/M00/01/49/wKgbVVjJHgOAXXq8AACAjS8b3Gc847.jpg?flow_flag=70721837&flow_type=1&flow_channel=api&dm_sid=15348521932327543057e73ad913f645&trackid=15348521932327543057e73ad913f645----&client_style=1\",\n" +
            "            \"title\": \"【刀剑神域序列争战】【最终加长版中文电影预告】\",\n" +
            "            \"url\": \"http://streaming-hls.icartoons.cn:7485/group1/M00/07/88/wKgbYFjLQ0GAQ_epAAABuaVyjVU17.m3u8\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"author\": \"saya\",\n" +
            "            \"cover\": \"http://img-wscdn.icartoons.cn/group6/M00/23/BB/wKgbVVq5qvqAKuSdAABAM4muF54709.jpg?flow_flag=70721837&flow_type=1&flow_channel=api&dm_sid=15348521932327543057e73ad913f645&trackid=15348521932327543057e73ad913f645----&client_style=1\",\n" +
            "            \"description\": \"颜瞳桐宅舞红叶爱呗\",\n" +
            "            \"id\": \"2S201803262200107071\",\n" +
            "            \"picture\": \"http://img-wscdn.icartoons.cn/group7/M00/23/BB/wKgbTVq5qvqAHUeHAADtyQKrP14382.jpg?flow_flag=70721837&flow_type=1&flow_channel=api&dm_sid=15348521932327543057e73ad913f645&trackid=15348521932327543057e73ad913f645----&client_style=1\",\n" +
            "            \"title\": \"颜瞳桐宅舞红叶爱呗\",\n" +
            "            \"url\": \"http://streaming-hls.icartoons.cn:7485/group2/M00/42/3E/wKgbX1q5qvyAZGLjAAABuUnjFIU33.m3u8\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"author\": \"怪西酱\",\n" +
            "            \"cover\": \"http://img-wscdn.icartoons.cn/group7/M00/23/AE/wKgbTVq3HsKARFgsAAA9j-JUU2o354.jpg?flow_flag=70721837&flow_type=1&flow_channel=api&dm_sid=15348521932327543057e73ad913f645&trackid=15348521932327543057e73ad913f645----&client_style=1\",\n" +
            "            \"description\": \"创作类型: 翻跳 \\n 编舞出处: av15243043 av16401926 \\n 歌曲出处: av15243043 有裁剪 \\n 摄影: 小皮 \\n 后期: 紫天 \\n 简介: 本身是准备的新年作让我一口气拖到春暖花开。。。。 对不起我有罪我减肥失败了orz\",\n" +
            "            \"id\": \"2S201803242200107027\",\n" +
            "            \"picture\": \"http://img-wscdn.icartoons.cn/group5/M00/23/E7/wKgbTlq3HsKALraiAAC3vy5eodI380.jpg?flow_flag=70721837&flow_type=1&flow_channel=api&dm_sid=15348521932327543057e73ad913f645&trackid=15348521932327543057e73ad913f645----&client_style=1\",\n" +
            "            \"title\": \"【怪西】寄明月✿大乔给您拜年啦！\",\n" +
            "            \"url\": \"http://streaming-hls.icartoons.cn:7485/group2/M00/24/38/wKgbWFq3HseANSC9AAABuYHLIEQ64.m3u8\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"author\": \"纪凉\",\n" +
            "            \"cover\": \"http://img-wscdn.icartoons.cn/group5/M00/23/F6/wKgbTlq56_GAU3KfAAA33ZBKLJc241.jpg?flow_flag=70721837&flow_type=1&flow_channel=api&dm_sid=15348521932327543057e73ad913f645&trackid=15348521932327543057e73ad913f645----&client_style=1\",\n" +
            "            \"description\": \"纪凉柸中有雪\",\n" +
            "            \"id\": \"2S201803272200107087\",\n" +
            "            \"picture\": \"http://img-wscdn.icartoons.cn/group6/M00/8A/1D/wKgbWVq56_GACurBAAB-19Q3wbI937.jpg?flow_flag=70721837&flow_type=1&flow_channel=api&dm_sid=15348521932327543057e73ad913f645&trackid=15348521932327543057e73ad913f645----&client_style=1\",\n" +
            "            \"title\": \"纪凉古风舞蹈柸中有雪\",\n" +
            "            \"url\": \"http://streaming-hls.icartoons.cn:7485/group2/M00/42/49/wKgbX1q56_OAcXRRAAABuWVPcQo74.m3u8\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"author\": \"EX炸裂\",\n" +
            "            \"cover\": \"http://img-wscdn.icartoons.cn/group5/M00/23/D6/wKgbTlq00pqAAmlIAAAhZsfC3Zc797.jpg?flow_flag=70721837&flow_type=1&flow_channel=api&dm_sid=15348521932327543057e73ad913f645&trackid=15348521932327543057e73ad913f645----&client_style=1\",\n" +
            "            \"description\": \"自制\\n\\n 去年囤稿\",\n" +
            "            \"id\": \"2S201803232200107011\",\n" +
            "            \"picture\": \"http://img-wscdn.icartoons.cn/group6/M00/23/9D/wKgbVVq00pqAU-caAABuLIhF18M506.jpg?flow_flag=70721837&flow_type=1&flow_channel=api&dm_sid=15348521932327543057e73ad913f645&trackid=15348521932327543057e73ad913f645----&client_style=1\",\n" +
            "            \"title\": \"【TaiTai】妄想感伤代偿联盟\",\n" +
            "            \"url\": \"http://streaming-hls.icartoons.cn:7485/group2/M00/41/AF/wKgbX1q00p6ADezvAAABuQVtGSA60.m3u8\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"author\": \"Rainbow小亚\",\n" +
            "            \"cover\": \"http://img-wscdn.icartoons.cn/group7/M00/8A/98/wKgbW1rOyVqAb9DeAAAk_V5IJXw615.jpg?flow_flag=70721837&flow_type=1&flow_channel=api&dm_sid=15348521932327543057e73ad913f645&trackid=15348521932327543057e73ad913f645----&client_style=1\",\n" +
            "            \"description\": \"活力满满的白T 短裤的小姐姐们，blackpink 像最后一样\",\n" +
            "            \"id\": \"2S201804112200107368\",\n" +
            "            \"picture\": \"http://img-wscdn.icartoons.cn/group5/M00/8A/D7/wKgbXlrOyVqAQTUEAABdWu4SMTY336.jpg?flow_flag=70721837&flow_type=1&flow_channel=api&dm_sid=15348521932327543057e73ad913f645&trackid=15348521932327543057e73ad913f645----&client_style=1\",\n" +
            "            \"title\": \"活力满满的白T短裤的小姐姐们，blackpink像最后一样\",\n" +
            "            \"url\": \"http://streaming-hls.icartoons.cn:7485/group2/M00/46/91/wKgbX1rOyVuAa6kIAAABueWcLOo83.m3u8\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"author\": \"RainBowS艺能团\",\n" +
            "            \"cover\": \"http://img-wscdn.icartoons.cn/group5/M00/24/12/wKgbTlq-BCyAKrrVAAA974fTuj8268.jpg?flow_flag=70721837&flow_type=1&flow_channel=api&dm_sid=15348521932327543057e73ad913f645&trackid=15348521932327543057e73ad913f645----&client_style=1\",\n" +
            "            \"description\": \"虽然还有很多不足但我们会努力带来更多更好的作品！ \\n 无锡总部招募中~~ 报名请加Q ：88313105\\n 新浪微博@RainBowS 艺能团 \\n 应援Q 群：120206201\\n 成员不定期直播频道：https://www.douyu.com/551586 \\n 公众号：RainBowS 艺能团 \\n 关注公众号了解成员最新资讯，更有惊喜等着你\",\n" +
            "            \"id\": \"2S201803302200107181\",\n" +
            "            \"picture\": \"http://img-wscdn.icartoons.cn/group6/M00/8A/39/wKgbWVq-BCyADxXKAADnD5EMtzI575.jpg?flow_flag=70721837&flow_type=1&flow_channel=api&dm_sid=15348521932327543057e73ad913f645&trackid=15348521932327543057e73ad913f645----&client_style=1\",\n" +
            "            \"title\": \"【RainBowS-伯爵】牵丝戏（原创振幅）\",\n" +
            "            \"url\": \"http://streaming-hls.icartoons.cn:7485/group1/M00/2E/62/wKgbWlq-BC-AGlujAAABuUEn_Z433.m3u8\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"author\": \"dm_ntu06sin56\",\n" +
            "            \"cover\": \"http://img-wscdn.icartoons.cn/group5/M00/23/ED/wKgbTlq4VCWAW_rKAAA6XNlSjjI285.jpg?flow_flag=70721837&flow_type=1&flow_channel=api&dm_sid=15348521932327543057e73ad913f645&trackid=15348521932327543057e73ad913f645----&client_style=1\",\n" +
            "            \"description\": \"春暖花开\\n 猫团和风录舞啦！\\n 甜甜的视频祝大家每天都开心！\",\n" +
            "            \"id\": \"2S201803252200107035\",\n" +
            "            \"picture\": \"http://img-wscdn.icartoons.cn/group6/M00/23/B4/wKgbVVq4VCWAE5HYAADdsnhDzH0989.jpg?flow_flag=70721837&flow_type=1&flow_channel=api&dm_sid=15348521932327543057e73ad913f645&trackid=15348521932327543057e73ad913f645----&client_style=1\",\n" +
            "            \"title\": \"【宅舞】白金DISCO-飞翔猫甜过初恋PV\",\n" +
            "            \"url\": \"http://streaming-hls.icartoons.cn:7485/group2/M00/24/39/wKgbWFq4VCeAHMO4AAABuW2g9yI23.m3u8\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"author\": \"怪西酱\",\n" +
            "            \"cover\": \"http://img-wscdn.icartoons.cn/group7/M00/23/AE/wKgbTVq3HsKARFgsAAA9j-JUU2o354.jpg?flow_flag=70721837&flow_type=1&flow_channel=api&dm_sid=15348521932327543057e73ad913f645&trackid=15348521932327543057e73ad913f645----&client_style=1\",\n" +
            "            \"description\": \"创作类型: 翻跳 \\n 编舞出处: av15243043 av16401926 \\n 歌曲出处: av15243043 有裁剪 \\n 摄影: 小皮 \\n 后期: 紫天 \\n 简介: 本身是准备的新年作让我一口气拖到春暖花开。。。。 对不起我有罪我减肥失败了orz\",\n" +
            "            \"id\": \"2S201803242200107027\",\n" +
            "            \"picture\": \"http://img-wscdn.icartoons.cn/group5/M00/23/E7/wKgbTlq3HsKALraiAAC3vy5eodI380.jpg?flow_flag=70721837&flow_type=1&flow_channel=api&dm_sid=15348521932327543057e73ad913f645&trackid=15348521932327543057e73ad913f645----&client_style=1\",\n" +
            "            \"title\": \"【怪西】寄明月✿大乔给您拜年啦！\",\n" +
            "            \"url\": \"http://streaming-hls.icartoons.cn:7485/group2/M00/24/38/wKgbWFq3HseANSC9AAABuYHLIEQ64.m3u8\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"size\": 20\n" +
            "}";


    private ArrayList<VideoItem> items;
    private int size;

    private transient SparseArray<VideoItem> map;

    public ArrayList<VideoItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<VideoItem> items) {
        this.items = items;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public VideoItem findItemById(String id) {
        if (map == null) {
            map = new SparseArray<>();
            for (VideoItem item : items) {
                map.append(item.getId().hashCode(), item);
            }
        }
        VideoItem item = map.get(id.hashCode());
        return item == null ? items.get(0) : item;
    }

}
