CREATE TABLE "users" (
    "id" BIGSERIAL NOT NULL,
    "nick" TEXT NOT NULL,
    "login" TEXT NOT NULL,
    "password" TEXT NOT NULL,
    "insert_time" TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT "users_pkey" PRIMARY KEY ("id")
);

CREATE TABLE "vehicles" (
    "id" BIGSERIAL NOT NULL,
    "brand" TEXT NOT NULL,
    "model" TEXT NOT NULL,
    "insert_time" TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "users_id" BIGINT,

    CONSTRAINT "vehicles_pkey" PRIMARY KEY ("id")
);

CREATE TABLE "insurance_offers" (
    "id" BIGSERIAL NOT NULL,
    "vehicles_id" BIGINT,
    "insurer" TEXT NOT NULL,
    "price" FLOAT NOT NULL,

    CONSTRAINT "insurance_offers_pkey" PRIMARY KEY ("id")
);

ALTER TABLE "vehicles" ADD CONSTRAINT "vehicles_users_id_fkey" FOREIGN KEY ("users_id") REFERENCES "users"("id") ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE "insurance_offers" ADD CONSTRAINT "insurance_offers_vehicles_id_fkey" FOREIGN KEY ("vehicles_id") REFERENCES "vehicles"("id") ON DELETE SET NULL ON UPDATE CASCADE;