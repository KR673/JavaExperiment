package com.wxb.commontest.modules;

/**
 * @Description: 作用描述
 * @Author: WangXiaoBo
 * @Date: 2019/6/21 14:21
 * @Version: 1.0
 */

import org.apache.commons.collections.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 对象验证器
 *
 * Created by Albert on 18/1/25.
 */
public class BeanValidator {

    /**
     * 验证某个bean的参数
     *
     * @param object 被校验的参数
     * @throws ValidationException 如果参数校验不成功则抛出此异常
     */
    public static <T> void validate(T object) {
        //获得验证器
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        //执行验证
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(object);
        //如果有验证信息，则取出来包装成异常返回
        if (CollectionUtils.isEmpty(constraintViolations)) {
            return;
        }

        String html = "<p>[toc]</p> \n" +
                "  <h1 id=\"Github-hext搭建个人线上笔记\"><a href=\"#Github-hext搭建个人线上笔记\" class=\"headerlink\" title=\"Github+hext搭建个人线上笔记\"></a>Github+hext搭建个人线上笔记</h1>\n" +
                "  <h2 id=\"1-github\"><a href=\"#1-github\" class=\"headerlink\" title=\"1. github\"></a>1. github</h2>\n" +
                "  <h3 id=\"1-1-创建仓库\"><a href=\"#1-1-创建仓库\" class=\"headerlink\" title=\"1.1 创建仓库\"></a>1.1 创建仓库</h3>\n" +
                "  <p><strong>注意</strong> 这个名字最好的<code>用户名.github.io</code>, 因为之 后使用hexo生成的静态文件中会使用 <code>/css/index.css</code>作为css的相对路径, 如果使用其他名字, github生成的网站地址会多出两级目录,导致找不到css和js文件</p> \n" +
                "  <p><img src=\"https://mynoteimg.oss-cn-beijing.aliyuncs.com/20191110222817.png\" alt=\"\" /></p> \n" +
                "  <h3 id=\"1-2-设置仓库\"><a href=\"#1-2-设置仓库\" class=\"headerlink\" title=\"1.2 设置仓库\"></a>1.2 设置仓库</h3>\n" +
                "  <p>在仓库的设置中设置GitHub Pages 为 master</p> \n" +
                "  <p><img src=\"https://mynoteimg.oss-cn-beijing.aliyuncs.com/20191110223555.png\" alt=\"\" /></p> \n" +
                "  <h2 id=\"2-hexo\"><a href=\"#2-hexo\" class=\"headerlink\" title=\"2. hexo\"></a>2. hexo</h2>\n" +
                "  <h3 id=\"2-1-安装\"><a href=\"#2-1-安装\" class=\"headerlink\" title=\"2.1 安装\"></a>2.1 安装</h3>\n" +
                "  <blockquote> \n" +
                "   <p>依照hexo的官方首页命令安装</p> \n" +
                "  </blockquote> \n" +
                "  <h3 id=\"2-2-布署\"><a href=\"#2-2-布署\" class=\"headerlink\" title=\"2.2 布署\"></a>2.2 布署</h3>\n" +
                "  <h4 id=\"2-2-1-生成静态文件\"><a href=\"#2-2-1-生成静态文件\" class=\"headerlink\" title=\"2.2.1 生成静态文件\"></a>2.2.1 生成静态文件</h4>\n" +
                "  <p>执行 : <code>hexo generate</code> 或 <code>hexo g</code></p> \n" +
                "  <h4 id=\"2-2-2-上传到github\"><a href=\"#2-2-2-上传到github\" class=\"headerlink\" title=\"2.2.2 上传到github\"></a>2.2.2 上传到github</h4>\n" +
                "  <ul> \n" +
                "   <li><p>修改根目录下的_config.yml文件, repository改为刚刚创建的Github仓库SSh链接</p> \n" +
                "    <figure class=\"highlight plain\">\n" +
                "     <table>\n" +
                "      <tbody>\n" +
                "       <tr>\n" +
                "        <td class=\"gutter\"><pre><span class=\"line\">1</span><br /><span class=\"line\">2</span><br /><span class=\"line\">3</span><br /><span class=\"line\">4</span><br /></pre></td>\n" +
                "        <td class=\"code\"><pre><span class=\"line\">deploy:</span><br /><span class=\"line\">type: git</span><br /><span class=\"line\">repository: git@github.com:KR673/note.github.io.git</span><br /><span class=\"line\">branch: master</span><br /></pre></td>\n" +
                "       </tr>\n" +
                "      </tbody>\n" +
                "     </table>\n" +
                "    </figure> <p> <strong>注意</strong>这个repository使用<strong>SSH链接</strong>而不是https</p> </li> \n" +
                "   <li><p>执行 : <code>hexo deploy</code> 或 <code>hexo d</code></p> </li> \n" +
                "  </ul> \n" +
                "  <h3 id=\"2-3-常用hexo命令\"><a href=\"#2-3-常用hexo命令\" class=\"headerlink\" title=\"2.3 常用hexo命令\"></a>2.3 常用hexo命令</h3>\n" +
                "  <figure class=\"highlight plain\">\n" +
                "   <table>\n" +
                "    <tbody>\n" +
                "     <tr>\n" +
                "      <td class=\"gutter\"><pre><span class=\"line\">1</span><br /><span class=\"line\">2</span><br /><span class=\"line\">3</span><br /><span class=\"line\">4</span><br /><span class=\"line\">5</span><br /><span class=\"line\">6</span><br /><span class=\"line\">7</span><br /></pre></td>\n" +
                "      <td class=\"code\"><pre><span class=\"line\">hexo new &quot;postName&quot; #新建文章</span><br /><span class=\"line\">hexo new page &quot;pageName&quot; #新建页面</span><br /><span class=\"line\">hexo generate #生成静态页面至public目录</span><br /><span class=\"line\">hexo server #开启预览访问端口（默认端口4000，'ctrl + c'关闭server）</span><br /><span class=\"line\">hexo deploy #部署到GitHub</span><br /><span class=\"line\">hexo help  # 查看帮助</span><br /><span class=\"line\">hexo version  #查看Hexo的版本</span><br /></pre></td>\n" +
                "     </tr>\n" +
                "    </tbody>\n" +
                "   </table>\n" +
                "  </figure> \n" +
                "  <p>缩写：</p> \n" +
                "  <figure class=\"highlight plain\">\n" +
                "   <table>\n" +
                "    <tbody>\n" +
                "     <tr>\n" +
                "      <td class=\"gutter\"><pre><span class=\"line\">1</span><br /><span class=\"line\">2</span><br /><span class=\"line\">3</span><br /><span class=\"line\">4</span><br /></pre></td>\n" +
                "      <td class=\"code\"><pre><span class=\"line\">hexo n == hexo new</span><br /><span class=\"line\">hexo g == hexo generate</span><br /><span class=\"line\">hexo s == hexo server</span><br /><span class=\"line\">hexo d == hexo deploy</span><br /></pre></td>\n" +
                "     </tr>\n" +
                "    </tbody>\n" +
                "   </table>\n" +
                "  </figure> \n" +
                "  <p>组合命令：</p> \n" +
                "  <figure class=\"highlight plain\">\n" +
                "   <table>\n" +
                "    <tbody>\n" +
                "     <tr>\n" +
                "      <td class=\"gutter\"><pre><span class=\"line\">1</span><br /><span class=\"line\">2</span><br /></pre></td>\n" +
                "      <td class=\"code\"><pre><span class=\"line\">hexo s -g #生成并本地预览</span><br /><span class=\"line\">hexo d -g #生成并上传</span><br /></pre></td>\n" +
                "     </tr>\n" +
                "    </tbody>\n" +
                "   </table>\n" +
                "  </figure>";

        throw new ValidationException(convertErrorMsg(constraintViolations));
    }

    /**
     * 转换异常信息
     * @param set
     * @param <T>
     * @return
     */
    private static <T> String convertErrorMsg(Set<ConstraintViolation<T>> set) {
        Map<String, StringBuilder> errorMap = new HashMap<>();
        String property;
        for (ConstraintViolation<T> cv : set) {
            //这里循环获取错误信息，可以自定义格式
            property = cv.getPropertyPath().toString();
            if (errorMap.get(property) != null) {
                errorMap.get(property).append("," + cv.getMessage());
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(cv.getMessage());
                errorMap.put(property, sb);
            }
        }
        return errorMap.toString();
    }
}
