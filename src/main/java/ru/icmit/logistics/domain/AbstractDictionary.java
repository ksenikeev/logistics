package ru.icmit.logistics.domain;

import javax.persistence.*;

/**
 * Базовый класс для справочников
 */
@MappedSuperclass
public class AbstractDictionary extends AbstractEntry {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dictionaryIdGenerator")
	@SequenceGenerator(name = "dictionaryIdGenerator", sequenceName = "dictionary_seq", allocationSize=1)
	private Long id;

	/** Статус актуальности. */
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, columnDefinition = "varchar(10) default 'Actual'")
	private DictActualityStatus actualityStatus;

	/** Внутренний код. */
	@Column(name = "code")
	private String code;

	@Column(name = "name", length = 512)
	private String name;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public DictActualityStatus getActualityStatus() {
		return actualityStatus;
	}

	public void setActualityStatus(DictActualityStatus actualityStatus) {
		this.actualityStatus = actualityStatus;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}