package dev.arealnemexis.publicatusnotes.datasource.mapper;

import dev.arealnemexis.publicatusnotes.datasource.dtos.request.UpdateNoteDto;
import dev.arealnemexis.publicatusnotes.datasource.dtos.response.NoteResponseDto;
import dev.arealnemexis.publicatusnotes.domain.NoteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )
public abstract class NoteMapper {
    public static final NoteMapper INSTANCE =
            Mappers.getMapper(NoteMapper.class);

    public abstract NoteResponseDto noteEntityToNoteResponseDto(NoteEntity note);

    public abstract void updateNoteFromDto(UpdateNoteDto dto, @MappingTarget NoteEntity entity);
}
