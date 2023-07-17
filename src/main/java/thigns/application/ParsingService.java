package thigns.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import thigns.domain.Writing;
import thigns.persistence.PageRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ParsingService {

    private final PageRepository pageRepository;

   /* public String parseMDToHTML(final String markdownContent) {
        final Parser parser = Parser.builder().build();
        final Node document = parser.parse(markdownContent);
        final HtmlRenderer renderer = HtmlRenderer.builder().build();
        return renderer.render(document);
    }*/

    @Transactional
    public void save(final String markdown) {
        final Writing writing = new Writing(markdown);
        pageRepository.save(writing);
    }
}
