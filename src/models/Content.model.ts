import {
    Table, Column, Model, DataType, ForeignKey, BelongsTo,
    HasMany, HasOne
} from 'sequelize-typescript';
import User from './User.model';
import ContentSubscription from './ContentSubscription.model';
import RecommendedPath from './RecommendedPath.model';
import RoomEntity from "./RoomEntity.model";

enum ContentType {
    CHARACTER = 'character',
    CLASS = 'class',
    SUBCLASS = 'subclass',
    FEATURE = 'feature',
    SPELL = 'spell',
    EFFECT = 'effect',
    ITEM = 'item',
    RACE = 'race',
    BACKGROUND = 'background',
    MONSTER = 'monster'
}

@Table({ tableName: 'content', timestamps: false, underscored: true })
export class Content extends Model {
    @Column({
        type: DataType.UUID,
        primaryKey: true,
        defaultValue: DataType.UUIDV4
    })
    id!: string;

    @Column({type: DataType.ENUM(...Object.values(ContentType)), allowNull: false})
    type!: ContentType;

    @ForeignKey(() => User)
    @Column({type: DataType.UUID, field: 'original_owner_id', allowNull: false})
    original_owner_id!: string;

    @ForeignKey(() => User)
    @Column({type: DataType.UUID, field: 'current_owner_id', allowNull: false})
    current_owner_id!: string;

    @Column({type: DataType.JSONB, allowNull: false})
    data!: object;

    @Column({type: DataType.BOOLEAN, allowNull: false})
    is_homebrew!: boolean;

    @Column({type: DataType.JSONB, allowNull: false})
    dependencies!: object;

    @Column({type: DataType.BOOLEAN, defaultValue: false})
    visibility!: boolean;

    @BelongsTo(() => User, 'original_owner_id')
    originalOwner!: User;

    @BelongsTo(() => User, 'current_owner_id')
    currentOwner!: User;

    @HasMany(() => ContentSubscription)
    subscriptions!: ContentSubscription[];

    @HasOne(() => RecommendedPath)
    recommendedPath!: RecommendedPath;

    @HasMany(() => RoomEntity)
    roomEntities!: RoomEntity[];
}

export default Content;