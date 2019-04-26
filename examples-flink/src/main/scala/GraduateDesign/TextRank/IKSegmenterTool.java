package GraduateDesign.TextRank;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;
import java.io.IOException;
import java.io.StringReader;
import java.util.Vector;

/**
 * Created by liuxiang on 2018/3/19.
 */
public class IKSegmenterTool {
    public static Vector<String> participle(String str ) {
        Vector<String> str1 = new Vector<String>() ;
        try {
            StringReader reader = new StringReader( str );
            IKSegmenter ik = new IKSegmenter(reader,true);
            Lexeme lexeme = null ;
            while( ( lexeme = ik.next() ) != null ) {
                str1.add( lexeme.getLexemeText() );
            }
        } catch ( IOException e1 ) {
        }
        return str1;
    }
}
