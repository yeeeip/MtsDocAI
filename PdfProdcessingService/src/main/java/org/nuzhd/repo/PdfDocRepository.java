package org.nuzhd.repo;

import org.nuzhd.model.PdfDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PdfDocRepository extends JpaRepository<PdfDoc, Long> {

    @Query(value = """
            select text from docs ORDER BY 
            (embedding <=> CAST(:queryVector AS vector))
            LIMIT 3
            """, nativeQuery = true
    )
    String[] getSimilarTextsByQuery(@Param("queryVector") float[] stringVector);

    @Query(value = """
                select (embedding <=> CAST(:vector AS vector)) as distance from docs
                order by distance
                LIMIT 3
            """, nativeQuery = true)
    Double[] getDistances(float[] vector);
}
