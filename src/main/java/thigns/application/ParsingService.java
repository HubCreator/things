package thigns.application;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ParsingService {

    public String parseMDToHTML(final String markdownContent) {
        final Parser parser = Parser.builder().build();
        final Node document = parser.parse(markdownContent);
        final HtmlRenderer renderer = HtmlRenderer.builder().build();
        return renderer.render(document);
    }
}
