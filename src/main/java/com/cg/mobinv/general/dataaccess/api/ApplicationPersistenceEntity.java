package com.cg.mobinv.general.dataaccess.api;

import io.oasp.module.jpa.dataaccess.api.MutablePersistenceEntity;

import javax.persistence.*;

import com.cg.mobinv.general.common.api.ApplicationEntity;

/**
 * Abstract Entity for all Entities with an id and a version field.
 */
@MappedSuperclass
public abstract class ApplicationPersistenceEntity implements ApplicationEntity, MutablePersistenceEntity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * @see #getId()
     */
    private Long id;

    /**
     * @see #getModificationCounter()
     */
    private int modificationCounter;

    /**
     * @see #getRevision()
     */
    private Number revision;

    /**
     * The constructor.
     */
    public ApplicationPersistenceEntity() {

        super();
    }

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {

        return this.id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setId(Long id) {

        this.id = id;
    }

    @Override
    @Version
    public int getModificationCounter() {

        return this.modificationCounter;
    }

    @Override
    public void setModificationCounter(int version) {

        this.modificationCounter = version;
    }

    @Override
    @Transient
    public Number getRevision() {

        return this.revision;
    }

    /**
     * @param revision the revision to set
     */
    @Override
    public void setRevision(Number revision) {

        this.revision = revision;
    }

    @Override
    public String toString() {

        StringBuilder buffer = new StringBuilder();
        toString(buffer);
        return buffer.toString();
    }

    /**
     * Method to extend {@link #toString()} logic.
     *
     * @param buffer is the {@link StringBuilder} where to {@link StringBuilder#append(Object)
     *        append} the string representation.
     */
    protected void toString(StringBuilder buffer) {

        buffer.append(getClass().getSimpleName());
        if (this.id != null) {
            buffer.append("[id=");
            buffer.append(this.id);
            buffer.append("]");
        }
    }
}