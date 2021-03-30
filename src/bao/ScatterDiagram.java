package bao;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/**
任务3-2
能够绘制任意一组D{0-1}KP数据以重量为横轴、价值为纵轴的数据散点图
**/
public class ScatterDiagram extends JPanel {
	
   int[] data = {
   //我随机取了idkp1-10.txt中的IDKP2:
   //widtht(profit)
211,718,929,21,172,193,684,695,1379,120,145,265,440,712,1152,134,373,507,471,578,1049,201,436,637,346,511,857,34,612,646,357,564,921,304,834,1138,478,636,1114,233,392,625,21,542,563,407,424,831,685,769,1454,511,570,1081,23,778,801,845,972,1817,272,764,1036,352,775,1127,8,395,403,176,497,673,150,152,302,725,969,1694,93,629,722,611,858,1469,742,789,1531,407,659,1066,645,657,1302,127,316,443,46,993,1039,721,964,1685,536,672,1208,68,254,322,179,540,719,485,979,1464,321,857,1178,75,695,770,548,779,1327,211,919,1130,699,865,1564,55,962,1017,421,447,868,51,319,370,396,546,942,159,982,1141,394,873,1267,556,936,1492,453,612,1065,160,709,869,706,895,1601,153,648,801,340,428,768,377,936,1313,310,757,1067,92,171,263,688,928,1616,190,728,918,422,423,845,55,281,336,156,584,740,433,850,1283,150,374,524,231,478,709,565,912,1477,150,882,1032,13,943,956,90,976,1066,419,943,1362,377,794,1171,589,871,1460,11,422,433,220,626,846,196,991,1187,127,623,750,184,837,1021,507,853,1360,171,547,718,381,451,832,738,991,1729,327,947,1274,169,635,804,11,844,855,244,892,1136,316,944,1260,198,205,403,270,274,544,775,845,1620,135,423,558,804,989,1793,118,552,670,752,913,1665,231,731,962,68,643,711,498,982,1480,515,917,1432,5,460,465,237,892,1129,571,831,1402,457,692,1149,729,826,1555,394,622,1016,92,299,391,92,207,299,393,999,1392,505,688,1193,465,870,1335,601,627,1228,25,322,347,29,751,780,43,354,397,385,961,1346,29,293,322,452,523,975,383,493,876,40,545,585,121,327,448,408,561,969,735,749,1484,23,870,893,827,961,1788,18,239,257,421,546,967,349,504,853,161,951,1112,473,620,1093,343,661,1004,301,954,1255,61,928,989,300,586,886,168,887,1055,563,690,1253,145,330,475,40,904,944,264,300,564,19,454,473,465,825,1290,473,874,1347,437,763,1200,662,744,1406,593,602,1195,577,964,1541,122,782,904,221,674,895,28,613,641,284,450,734,614,971,1585,110,729,839,442,761,1203,769,802,1571,152,327,479,514,854,1368,267,511,778,437,800,1237,460,468,928,50,115,165,475,626,1101,106,391,497,8,952,960,363,519,882,306,558,864,67,739,806,275,408,683,204,316,520,156,686,842,134,997,1131,813,834,1647,178,217,395,675,791,1466,478,482,960,501,650,1151,724,944,1668,76,592,668,24,962,986,347,792,1139,460,932,1392,263,937,1200,721,782,1503,584,781,1365,483,636,1119,367,727,1094,722,743,1465,288,762,1050,585,894,1479,567,735,1302,407,788,1195,199,545,744,285,580,865,347,959,1306,130,157,287,66,145,211,159,553,712,403,967,1370,170,920,1090,551,968,1519,175,543,718,341,499,840,426,560,986

   //height
,311,818,1074,121,272,365,784,795,1167,220,245,294,540,812,1084,234,473,553,571,678,1207,301,536,644,446,611,928,134,712,773,457,664,740,404,934,1009,578,736,1256,333,492,783,121,642,649,507,524,824,785,869,1604,611,670,862,123,878,997,945,1072,1363,372,864,1227,452,875,1141,108,495,566,276,597,868,250,252,485,825,1069,1349,193,729,859,711,958,1058,842,889,1302,507,759,836,745,757,1169,227,416,459,146,1093,1198,821,1064,1822,636,772,1385,168,354,441,279,640,876,585,1079,1514,421,957,1372,175,795,895,648,879,890,311,1019,1268,799,965,1024,155,1062,1127,521,547,583,151,419,445,496,646,907,259,1082,1172,494,973,1008,656,1036,1327,553,712,1076,260,809,1056,806,995,1297,253,748,841,440,528,567,477,1036,1332,410,857,1066,192,271,328,788,1028,1272,290,828,946,522,523,919,155,381,479,256,684,920,533,950,1192,250,474,655,331,578,649,665,1012,1115,250,982,1175,113,1043,1046,190,1076,1140,519,1043,1256,477,894,1078,689,971,1256,111,522,556,320,726,776,296,1091,1169,227,723,793,284,937,1027,607,953,1035,271,647,772,481,551,636,838,1091,1491,427,1047,1400,269,735,818,111,944,992,344,992,1094,416,1044,1258,298,305,344,370,374,742,875,945,1405,235,523,751,904,1089,1525,218,652,800,852,1013,1830,331,831,1086,168,743,880,598,1082,1126,615,1017,1057,105,560,615,337,992,1271,671,931,1502,557,792,955,829,926,1585,494,722,882,192,399,565,192,307,471,493,1099,1319,605,788,1272,565,970,1478,701,727,841,125,422,471,129,851,882,143,454,457,485,1061,1382,129,393,426,552,623,823,483,593,797,140,645,702,221,427,626,508,661,1095,835,849,1351,123,970,1050,927,1061,1878,118,339,365,521,646,893,449,604,846,261,1051,1295,573,720,1018,443,761,1069,401,1054,1128,161,1028,1053,400,686,847,268,987,1188,663,790,1130,245,430,485,140,1004,1079,364,400,538,119,554,616,565,925,1473,573,974,1135,537,863,1377,762,844,1371,693,702,1195,677,1064,1594,222,882,1032,321,774,1032,128,713,760,384,550,888,714,1071,1782,210,829,1018,542,861,1075,869,902,1129,252,427,506,614,954,1160,367,611,942,537,900,923,560,568,967,150,215,333,575,726,1298,206,491,551,108,1052,1054,463,619,819,406,658,898,167,839,853,375,508,810,304,416,649,256,786,889,234,1097,1165,913,934,1104,278,317,560,775,891,1586,578,582,652,601,750,1299,824,1044,1138,176,692,866,124,1062,1140,447,892,1226,560,1032,1209,363,1037,1352,821,882,1094,684,881,1258,583,736,784,467,827,954,822,843,1545,388,862,1143,685,994,1196,667,835,1415,507,888,1066,299,645,844,385,680,699,447,1059,1098,230,257,419,166,245,308,259,653,830,503,1067,1369,270,1020,1059,651,1068,1256,275,643,693,441,599,829,526,660,1074

    };//输入对应的数据，是integer（整数）

    final int PAD = 20;

	protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	
	Graphics2D g2 = (Graphics2D)g;
	
	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	
	RenderingHints.VALUE_ANTIALIAS_ON);
	
	int h = getHeight();//重量
	int w = getWidth();	//价值

	// 横坐标	
	g2.draw(new Line2D.Double(PAD, w-PAD, h-PAD, w-PAD));
	// 纵坐标
	g2.draw(new Line2D.Double(PAD, PAD, PAD, w-PAD));
	
	
	double xInc = (double)(w - 2*PAD)/(data.length-1);
	double scale = (double)(h - 2*PAD)/getMax();
	
	// 数据点（坐标）	
	g2.setPaint(Color.blue);//点的颜色
	
	for(int i = 0; i < data.length; i++) {
	double x = PAD + i*xInc;	
	double y = h - PAD - scale*data[i];	
	g2.fill(new Ellipse2D.Double(x-2, y-2, 4, 4));	
	}

}

	private int getMax() {
		int max = -Integer.MAX_VALUE;		
		for(int i = 0; i < data.length; i++) {
		if(data[i] > max)	
		max = data[i];		
		}
		
		return max;
	
	}

	public static void main(String[] args) {
		JFrame f = new JFrame();		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		f.add(new ScatterDiagram());		
		f.setSize(300,300);
		f.setLocation(200,200);		
		f.setVisible(true);
	    }

}
