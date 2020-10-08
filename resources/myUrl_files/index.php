function votecountadmin() {
	var a = 0;
	var b = 0;
	var results = [];
	var trunc;
	for (j=0; $("h3").eq(j).find("span").attr("id") !== undefined; j++) {
		results[a] = 0;
		results[a+1] = 0;
		results[a+2] = 0;
		for (i=0; $("h4").eq(a).nextUntil("h4").children("li").eq(i).html() !== undefined; i++) 
			results[a] = i+1;
		$("td.support").eq(j).text(results[a]);
		for (i=0; $("h4").eq(a+1).nextUntil("h4").children("li").eq(i).html() !== undefined; i++) 
			results[a+1] = i+1;
		$("td.oppose").eq(j).text(results[a+1]);
		for (i=0; $("h4").eq(a+2).nextUntil("h4").children("li").eq(i).html() !== undefined; i++) 
			results[a+2] = i+1;
		$("td.neutral").eq(j).text(results[a+2]);
		results[a+3] = results[a]/(results[a]+results[a+1])*100;
		trunc = results[a+3].toFixed(2);
		$("td.percent").eq(j).text(trunc);
		for(i=1; $("h4").eq(b+1).children("span").eq(1).attr("id").search(/_За/i) == -1; i++) 
			b = i+a;
		b++;
		a = b;
	}
}
function votecountarbitr() {
	var a = 0;
	var b = 0;
	var results = [];
	var trunc;
	for (j=0; $("h2").eq(j+1).find("span").attr("id") !== undefined; j++) {
		a = 3*j;
		b = 2*j;
		results[a] = 0;
		results[a+1] = 0;
		results[a+2] = 0;
		for (i=0; $("h3").eq(b).nextUntil("h3").children("li").eq(i).html() !== undefined; i++) 
			results[a] = i+1;
		$("td.support").eq(j).text(results[a]);
		for (i=0; $("h3").eq(b+1).nextUntil("h3").children("li").eq(i).html() !== undefined; i++) 
			results[a+1] = i+1;
		$("td.oppose").eq(j).text(results[a+1]);
		results[a+2] = results[a]/(results[a]+results[a+1])*100;
		trunc = parseFloat(results[a+2].toFixed(2));
		$("td.percent").eq(j).text(trunc);
		if (trunc >= 75)
			$("td.percent").eq(j).css("background", "#33ff33");
		else
			$("td.percent").eq(j).css("background","#ff3333");
	}
}
var PageName = mw.config.get( 'wgPageName' );
if(PageName === "Користувач:Andriy.v/Заявки_на_позбавлення_прав_адміністратора" || PageName === "Користувач:Andriy.v/Заявки_на_права_адміністратора")
	$(votecountadmin);
if(PageName === "Користувач:Andriy.v/Попередні_результати")
	$(votecountarbitr);