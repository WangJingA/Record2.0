package com.example.dayrecords.Crawer;//package com.example.dayrecords.Crawer;
//
//import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
//import cn.edu.hfut.dmic.webcollector.model.Page;
//import cn.edu.hfut.dmic.webcollector.plugin.rocks.BreadthCrawler;
//
//
//import java.io.IOException;
//import java.util.regex.Pattern;
//
//public class ZhihuCrawler extends BreadthCrawler {
//
//    public ZhihuCrawler(String crawlPath, boolean autoParse) {
//        super(crawlPath, autoParse);
//    }
//
//    /*visit函数定制访问每个页面时所需进行的操作*/
//    @Override
//    public void visit(Page page, CrawlDatums crawlDatums) {
//        String question_regex="^http://www.zhihu.com/question/[0-9]+";
//        if(Pattern.matches(question_regex, page.getUrl())){
//            System.out.println("正在抽取"+page.getUrl());
//            /*抽取标题*/
//            String title=page.getDoc().title();
//            System.out.println(title);
//            /*抽取提问内容*/
//            String question=page.getDoc().select("div[id=zh-question-detail]").text();
//            System.out.println(question);
//
//        }
//    }
//
//    /*启动爬虫*/
//    public static void main(String[] args) throws Exception {
//        ZhihuCrawler crawler=new ZhihuCrawler();
//        crawler.addSeed("http://www.zhihu.com/question/21003086");
//        crawler.addRegex("http://www.zhihu.com/.*");
//        crawler.start(5);
//    }
//
//
//}
