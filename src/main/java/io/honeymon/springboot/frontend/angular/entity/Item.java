package io.honeymon.springboot.frontend.angular.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
 * @author honeymon
 *
 */
@Entity
@NoArgsConstructor
@EqualsAndHashCode(of = { "title", "type" })
@ToString(of = { "title", "type" })
public class Item implements Serializable {
	private static final long serialVersionUID = -5145280372216671121L;

	@Getter
	@Id
	@GeneratedValue
	private Long id;

	@Getter
	@Column(nullable = false)
	private String title;

	@Getter
	@Column
	private String description;

	@Getter
	private String type;

	public Item(String title, String type) {
		super();
		this.title = title;
		this.type = type;
	}

}
