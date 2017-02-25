package org.example.data;

import org.example.domain.Measurement;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MeasurementRepository<T extends Measurement> extends ModelRepository<T>, ExtendedMeasurementRepository<T>
{
}
