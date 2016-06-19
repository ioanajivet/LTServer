package mypackage;
 
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
 
public class HelloServlet extends HttpServlet {

   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws IOException, ServletException {
	PrintWriter writer = response.getWriter();

        try{
           String userId = request.getParameter("userId").toString();
	   String reply = "function timeStamp() {\n" +
                "\tvar now = new Date();\n" +
                "\tvar date = [ now.getFullYear(), now.getMonth() + 1, now.getDate() ];\n" +
                "\tvar time = [ now.getHours(), now.getMinutes(), now.getSeconds() ];\n" +
                "\n" +
                "\tfor ( var i = 1; i < 3; i++ ) {\n" +
                "\t\tif ( time[i] < 10 ) {\n" +
                "\t\t\ttime[i] = \"0\" + time[i];\n" +
                "\t\t}\n" +
                "\t}\n" +
                "\n" +
                "\tif( date[1] < 10 ) {\n" +
                "\t\tdate[1] = \"0\" + date[1];\n" +
                "\t}\n" +
                "\n" +
                "\treturn date.join(\"-\") + \"Z\" + time.join(\":\");\n" +
                "}\n" +
                "\n" +
                "var metricNames = ['Sessions per week',\n" +
                "'Average length of a session',\n" +
                "'Average time between sessions',\n" +
                "'Forum sessions',\n" +
                "'Weekly assessment answers submitted',\n" +
                "'Timeliness of weekly assessment submission'];\n" +
                "var metricUnits = ['',\n" +
                "'min',\n" +
                "'h',\n" +
                "'',\n" +
                "'',\n" +
                "'h'];\n" +
                "\n" +
                "var values = [0,0,0,0,0,0];\n" +
                "var thisWeek = [5,34,71,14,22,127];\n" +
                "var nextWeek = [5,34,70,17,28,124];\n" +
                "\n" +
                "function getSeriesValue(chart, i) {\n" +
                "\t\n" +
                "\tif(chart.points[i].series.name == 'You')\n" +
                "\t\treturn values[chart.x/60];\n" +
                "\telse if(chart.points[i].series.name == 'Average graduate last week')\n" +
                "\t\treturn thisWeek[chart.x/60];\n" +
                "\telse \n" +
                "\t\treturn nextWeek[chart.x/60];\n" +
                "}\n" +
                "function loadWidget() {\n" +
                "\t\n" +
                "\tvar user_id = 'a';\n" +
                "\t\n" +
                "\t$('#container').highcharts({\n" +
                "\t\tchart: {\n" +
                "\t\t\tmarginTop: 120,\n" +
                "\t\t\tpolar: true,\n" +
                "\t\t\tstyle: {\n" +
                "\t\t\t\tfontFamily: 'Open Sans, sans-serif'\n" +
                "\t\t\t},\n" +
                "\t\t\ttype: 'area',\n" +
                "\t\t\tevents: {\n" +
                "\t\t\t\tload: function () {\n" +
                "\t\t\t\t\tvar category = user_id + '_week6';\n" +
                "\t\t\t\t\tgaST('send', 'event', category, 'load_' + timeStamp());\n" +
                "\t\t\t\t}\n" +
                "\t\t\t}\n" +
                "\t\t},\n" +
                "\n" +
                "\t\ttitle: {\n" +
                "\t\t\ttext: 'Learning tracker',\n" +
                "\t\t\tstyle: {\n" +
                "\t\t\t\talign: 'left'\n" +
                "\t\t\t}\n" +
                "\t\t},\n" +
                "\n" +
                "\t\t\t\t\t\t\n" +
                "\t\tsubtitle: {\n" +
                "        \tuseHTML: true,\n" +
                "\t\t\tstyle: {\n" +
                "\t\t\t\talign: 'center'\n" +
                "\t\t\t},\n" +
                "            text: '<div style=\"border: 2px solid black; margin: 10px; padding: 5px; border-radius: 15px; text-align: center;\">Don\\'t let us down now!  You\\'re a bit behind right now, but we\\'re doing our best to introduce you to exciting new topics each week. Please don\\'t continue to fall behind.</div>'\n" +
                "\t\t\t\n" +
                "        },\n" +
                "\n" +
                "\t\tcredits: {\n" +
                "\t\t\tenabled: false\n" +
                "\t\t},\n" +
                "\n" +
                "\t\tlegend: {\n" +
                "\t\t\treversed: true\n" +
                "\t\t},\n" +
                "\n" +
                "\t\tpane: {\n" +
                "\t\t\tstartAngle: 0,\n" +
                "\t\t\tendAngle: 360\n" +
                "\t\t},\n" +
                "\n" +
                "\t\txAxis: {\n" +
                "\t\t\ttickInterval: 60,\n" +
                "\t\t\tmin: 0,\n" +
                "\t\t\tmax: 360,\n" +
                "\t\t\tlabels: {\n" +
                "\t\t\t\tformatter: function () {\n" +
                "\t\t\t\t\treturn metricNames[this.value/60];\n" +
                "\t\t\t\t}\n" +
                "\t\t\t},\n" +
                "\t\t\tgridLineWidth: 1\n" +
                "\t\t},\n" +
                "\n" +
                "\t\tyAxis: {\n" +
                "\t\t\tmin: 0,\n" +
                "\t\t\tmax: 10,\n" +
                "\t\t\tgridLineWidth: 1,\n" +
                "\t\t\tlabels: {\n" +
                "\t\t\t\tenabled: false\n" +
                "\t\t\t},\n" +
                "\t\t\ttickPositions: [0, 5, 10],\n" +
                "\t\t\tvisible: true\n" +
                "\t\t},\n" +
                "\n" +
                "\t\tplotOptions: {\n" +
                "\t\t\tseries: {\n" +
                "\t\t\t\tallowPointSelect: true,\n" +
                "\t\t\t\tpointStart: 0,\n" +
                "\t\t\t\tpointInterval: 60,\n" +
                "\t\t\t\tcursor: 'pointer',\n" +
                "\t\t\t\tmarker: {\n" +
                "\t\t\t\t\tsymbol: 'diamond',\n" +
                "\t\t\t\t\tradius: 3\n" +
                "\t\t\t\t}\n" +
                "\t\t\t},\n" +
                "\t\t\tcolumn: {\n" +
                "\t\t\t\tpointPadding: 0,\n" +
                "\t\t\t\tgroupPadding: 0\n" +
                "\t\t\t}\n" +
                "\t\t},\n" +
                "\n" +
                "\t\ttooltip: {\n" +
                "\t\t\tshared: true,\n" +
                "\t\t\tformatter: function () {\n" +
                "\t\t\t\tvar tooltip_text = '<b>' + metricNames[this.x/60] + '</b>';\n" +
                "\t\t\t\tvar unit = metricUnits[this.x/60];\n" +
                "\n" +
                "\t\t\t\tfor (i = this.points.length - 1; i >= 0; i--) { \n" +
                "\t\t\t\t\ttooltip_text += '<br/>' + this.points[i].series.name + ': <b>' + getSeriesValue(this, i) + ' ' + unit + '</b>';\n" +
                "\t\t\t\t}\n" +
                "\n" +
                "\t\t\t\treturn tooltip_text;\n" +
                "\t\t\t},\n" +
                "\t\t},\n" +
                "\t\t\n" +
                "\t\tseries: [\t\t\n" +
                "\t\t{\n" +
                "\t\t\ttype: 'line',\n" +
                "\t\t\tname: 'Average graduate this week',\n" +
                "\t\t\tcolor: 'rgba(188, 64, 119, 0.5)',\n" +
                "\t\t\tdata: [2.5,3.7,2.1,2,7.2,3.7],\n" +
                "\t\t\tvisible: false,\n" +
                "\t\t\tevents: {\n" +
                "\t\t\t\tshow: function () {\n" +
                "\t\t\t\t\tgaST('send', 'event', user_id + '_week6', 'show-this-week_' + timeStamp());\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\thide: function () {\n" +
                "\t\t\t\t\tgaST('send', 'event', user_id + '_week6', 'hide-this-week_' + timeStamp());\n" +
                "\t\t\t\t}\n" +
                "\t\t\t}\n" +
                "\t\t},\n" +
                "\n" +
                "\t\t{\n" +
                "\t\t\tname: 'Average graduate last week',\n" +
                "\t\t\tcolor: 'rgba(255, 255, 102, 0.5)',\n" +
                "\t\t\tdata: [2.5,3.9,2.4,1.7,6.3,3.8], \n" +
                "\t\t\tevents: {\n" +
                "\t\t\t\tshow: function () {\n" +
                "\t\t\t\t\tgaST('send', 'event', user_id + '_week6', 'show-last-week_' + timeStamp());\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\thide: function () {\n" +
                "\t\t\t\t\tgaST('send', 'event', user_id + '_week6', 'hide-last-week_' + timeStamp());\n" +
                "\t\t\t\t}\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t},\n" +
                "\n" +
                "\t\t{\n" +
                "\t\t\tname: 'You',\n" +
                "\t\t\tcolor: 'rgba(144, 202, 249, 0.5)',\n" +
                "\t\t\tdata: [0.0,0.0,5.4,3.2,0.0,0.0],\n" +
                "\t\t\tevents: {\n" +
                "\t\t\t\tshow: function () {\n" +
                "\t\t\t\t\tgaST('send', 'event', user_id + '_week6', 'show-you_' + timeStamp());\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\thide: function () {\n" +
                "\t\t\t\t\tgaST('send', 'event', user_id + '_week6', 'hide-you_' + timeStamp());\n" +
                "\t\t\t\t}\n" +
                "\t\t\t}\n" +
                "\t\t}]\n" +
                "\t});\n" +
                "}\n" +
                "\t\t\n" +
                "loadWidget();";
           writer.write(reply);
           writer.close();
           }
       catch(Exception ex) {
              ex.getStackTrace();
       } finally {
         writer.close();  // Always close the output writer
       }
   }
}
